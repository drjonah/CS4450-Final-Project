
package finalproject;

// Open GL
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.input.Keyboard; // Keyboard input
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.glu.GLU;

/**
 *
 * @author Jonah & Michael
 */
public class FinalProject {
    
    // Camera
    private CameraController camera = new CameraController(0, 15, 0, 0.09f, 0.35f);
    private DisplayMode displayMode;
    
    public String title;
    public int width;
    public int height;
    
    // Default constructor
    public FinalProject() {
        this.title = "Final Project: Minecraft";
        this.width = 640;
        this.height = 480;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FinalProject app = new FinalProject();
        app.start();
    }
    
    /** 
     * Method: start
     * Purpose: This method is the control flow of logic for OpenGL.
     */
    public void start() {
        try {
            System.out.println("Starting window...");
            
            createWindow();
            initGL();
            
            render();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    /**
     * Method: createWindow
     * Purpose: This method creates the window for which the shapes exist.
     */
    private void createWindow() throws Exception {
        System.out.println("Creating window...");
        
        Display.setFullscreen(false);

        DisplayMode d[] = Display.getAvailableDisplayModes();
        for (int i = 0; i < d.length; ++i) {
            if (d[i].getWidth() == this.width && d[i].getHeight() == this.height && d[i].getBitsPerPixel() == 32) {
                this.displayMode = d[i];
                break;
            }
        }
        Display.setDisplayMode(this.displayMode);

        Display.setTitle(this.title);
        Display.create();
    }
    
    /**
     * Method: initGL
     * Purpose: This method sets the properties (bg color, name, etc) for the window.
     */
    private void initGL() {
        System.out.println("Initializing OpenGL...");
        
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        
        GLU.gluPerspective(100f, (float) this.width / (float) this.width, 0.1f, 300f);

        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST); // anti aliasing 
    }
    
    private void render() {
        
        Cube cube = new Cube(0, -5, 10, 10);  // Create the cube
    
        while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glLoadIdentity();
            glPointSize(1);
            
            // Camera
            camera.readControls();
        
            // Render the cube
            cube.render();
        
            Display.update();
            Display.sync(60);
        }
    
        Display.destroy();
    }
    
}
