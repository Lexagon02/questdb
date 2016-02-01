/*******************************************************************************
 *  _  _ ___ ___     _ _
 * | \| | __/ __| __| | |__
 * | .` | _|\__ \/ _` | '_ \
 * |_|\_|_| |___/\__,_|_.__/
 *
 * Copyright (c) 2014-2016. The NFSdb project and its contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.nfsdb.ql.ops;

import com.nfsdb.ex.JournalRuntimeException;
import com.nfsdb.factory.configuration.ColumnMetadata;
import com.nfsdb.ql.AggregatorFunction;
import com.nfsdb.ql.Record;
import com.nfsdb.ql.impl.map.MapRecordValueInterceptor;
import com.nfsdb.ql.impl.map.MapValues;
import com.nfsdb.std.ObjList;
import com.nfsdb.store.ColumnType;

public final class VwapAggregator extends AbstractBinaryOperator implements AggregatorFunction, MapRecordValueInterceptor {

    public static final VwapAggregator FACTORY = new VwapAggregator();

    private int sumAmtIdx;
    private int sumQtyIdx;
    private int vwap;

    private VwapAggregator() {
        super(ColumnType.DOUBLE);
    }

    @Override
    public void beforeRecord(MapValues values) {
        values.putDouble(vwap, values.getDouble(sumAmtIdx) / values.getDouble(sumQtyIdx));
    }

    @Override
    public void calculate(Record rec, MapValues values) {
        double price = lhs.getDouble(rec);
        double quantity = rhs.getDouble(rec);
        if (values.isNew()) {
            values.putDouble(sumAmtIdx, price * quantity);
            values.putDouble(sumQtyIdx, quantity);
        } else {
            values.putDouble(sumAmtIdx, values.getDouble(sumAmtIdx) + price * quantity);
            values.putDouble(sumQtyIdx, values.getDouble(sumQtyIdx) + quantity);
        }
    }

    @Override
    public ColumnMetadata[] getColumns() {
        return new ColumnMetadata[]{
                new ColumnMetadata().setName("$sumAmt").setType(ColumnType.DOUBLE)
                , new ColumnMetadata().setName("$sumQty").setType(ColumnType.DOUBLE)
                , new ColumnMetadata().setName(getName()).setType(ColumnType.DOUBLE)
        };
    }

    @Override
    public void mapColumn(int k, int i) {
        switch (k) {
            case 0:
                sumAmtIdx = i;
                break;
            case 1:
                sumQtyIdx = i;
                break;
            case 2:
                vwap = i;
                break;
            default:
                throw new JournalRuntimeException("Internal bug. Column mismatch");
        }
    }

    @Override
    public Function newInstance(ObjList<VirtualColumn> args) {
        return new VwapAggregator();
    }
}
