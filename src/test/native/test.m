#include <jni.h>

int main(int argc, char** args)
{
    JavaVM *jvm;       /* denotes a Java VM */
    JNIEnv *env;       /* pointer to native method interface */
    JavaVMInitArgs vm_args; /* JDK/JRE 9 VM initialization arguments */
    JNI_GetDefaultJavaVMInitArgs(&vm_args);
    JavaVMOption options[1];
    options[0].optionString = "-Djava.class.path=/Users/nsano/src/java/vavi-nio-file-discutils/target/vavi-qlgenerator.jar";
    vm_args.version = JNI_VERSION_1_8;
    vm_args.nOptions = 1;
    vm_args.options = options;
    vm_args.ignoreUnrecognized = JNI_FALSE;
    /* load and initialize a Java VM, return a JNI interface
     * pointer in env */
    JNI_CreateJavaVM(&jvm, (void**) &env, &vm_args);
    /* invoke the Main.test method using the JNI */
    jclass cls = (*env)->FindClass(env, "vavi/apps/qlgenerator/Chd");
    jmethodID mid = (*env)->GetStaticMethodID(env, cls, "exec", "(Ljava/lang/String;)Ljava/lang/String;");
    jstring _url = (*env)->NewStringUTF(env, argc > 1 ? args[1] : "http://java.sun.com");
    jobject _str = (*env)->CallStaticObjectMethod(env, cls, mid, _url);
    const char *str = (*env)->GetStringUTFChars(env, _str, 0);

    fprintf(stderr, "return: %s\n", str);

    /* We are done. */
    (*jvm)->DestroyJavaVM(jvm);
}
