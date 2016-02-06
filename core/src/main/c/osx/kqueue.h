/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_nfsdb_net_Kqueue */

#ifndef _Included_com_nfsdb_net_Kqueue
#define _Included_com_nfsdb_net_Kqueue
#ifdef __cplusplus
extern "C" {
#endif
#undef com_nfsdb_net_Kqueue_NUM_KEVENTS
#define com_nfsdb_net_Kqueue_NUM_KEVENTS 1024L
/*
 * Class:     com_nfsdb_net_Kqueue
 * Method:    kevent
 * Signature: (IJIJI)I
 */
JNIEXPORT jint JNICALL Java_com_nfsdb_net_Kqueue_kevent
        (JNIEnv *, jclass, jint, jlong, jint, jlong, jint);

/*
 * Class:     com_nfsdb_net_Kqueue
 * Method:    kqueue
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_nfsdb_net_Kqueue_kqueue
        (JNIEnv *, jclass);

/*
 * Class:     com_nfsdb_net_Kqueue
 * Method:    getEvfiltRead
 * Signature: ()S
 */
JNIEXPORT jshort JNICALL Java_com_nfsdb_net_Kqueue_getEvfiltRead
        (JNIEnv *, jclass);

/*
 * Class:     com_nfsdb_net_Kqueue
 * Method:    getEvfiltWrite
 * Signature: ()S
 */
JNIEXPORT jshort JNICALL Java_com_nfsdb_net_Kqueue_getEvfiltWrite
        (JNIEnv *, jclass);

/*
 * Class:     com_nfsdb_net_Kqueue
 * Method:    getSizeofKevent
 * Signature: ()S
 */
JNIEXPORT jshort JNICALL Java_com_nfsdb_net_Kqueue_getSizeofKevent
        (JNIEnv *, jclass);

/*
 * Class:     com_nfsdb_net_Kqueue
 * Method:    getFdOffset
 * Signature: ()S
 */
JNIEXPORT jshort JNICALL Java_com_nfsdb_net_Kqueue_getFdOffset
        (JNIEnv *, jclass);

/*
 * Class:     com_nfsdb_net_Kqueue
 * Method:    getFilterOffset
 * Signature: ()S
 */
JNIEXPORT jshort JNICALL Java_com_nfsdb_net_Kqueue_getFilterOffset
        (JNIEnv *, jclass);

/*
 * Class:     com_nfsdb_net_Kqueue
 * Method:    getEvAdd
 * Signature: ()S
 */
JNIEXPORT jshort JNICALL Java_com_nfsdb_net_Kqueue_getEvAdd
        (JNIEnv *, jclass);

/*
 * Class:     com_nfsdb_net_Kqueue
 * Method:    getEvOneshot
 * Signature: ()S
 */
JNIEXPORT jshort JNICALL Java_com_nfsdb_net_Kqueue_getEvOneshot
        (JNIEnv *, jclass);

/*
 * Class:     com_nfsdb_net_Kqueue
 * Method:    getFlagsOffset
 * Signature: ()S
 */
JNIEXPORT jshort JNICALL Java_com_nfsdb_net_Kqueue_getFlagsOffset
        (JNIEnv *, jclass);


/*
 * Class:     com_nfsdb_net_Kqueue
 * Method:    getDataOffset
 * Signature: ()S
 */
JNIEXPORT jshort JNICALL Java_com_nfsdb_net_Kqueue_getDataOffset
        (JNIEnv *, jclass);
#ifdef __cplusplus
}
#endif
#endif
