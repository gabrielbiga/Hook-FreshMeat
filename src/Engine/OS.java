//Especificos de sistema operacional
package Engine;

import java.awt.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OS {

    public static class MacOS {

        public static boolean isMacOSX() {
            return System.getProperty("os.name").indexOf("Mac OS X") >= 0;
        }

        public static void enableFullScreenMode(Window window) {
            String className = "com.apple.eawt.FullScreenUtilities";
            String methodName = "setWindowCanFullScreen";

            try {
                Class<?> clazz = Class.forName(className);
                Method method = clazz.getMethod(methodName, new Class<?>[]{
                    Window.class, boolean.class});
                method.invoke(null, window, true);
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException t) {
                System.err.println("Full screen mode is not supported");
            }
        }
    }

}
