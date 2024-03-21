
package finalproject;

import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Jonah & Michael
 */
public class CameraController {
    
    // Store the camera's position
    private Vector3f position = null;
//    private Vector3f lPosition = null;
    
    private float yaw = 0f; // Rotation around the y-axis
    private float pitch = 0f; // Rotation around the x-axis
    
    // Settings
    final private float mouseSensitivity;
    final private float movementSpeed;
    
    public CameraController(float x, float y, float z, float sensitivity, float speed) {
        this.position = new Vector3f(x, y, z);
        
//        this.lPosition = new Vector3f(x, y, z);
//        this.lPosition.x = 0f;
//        this.lPosition.y = 15f;
//        this.lPosition.z = 0f;
        
        this.mouseSensitivity = sensitivity;
        this.movementSpeed = speed;
        
        // Hide mouse
        Mouse.setGrabbed(true);
    }
    
    public void yaw(float amount) { this.yaw += amount; }
    public void pitch(float amount) { this.pitch -= amount; }
    
    // Move camera forward
    public void forward(float distance) {
        float xOffset = distance * (float) Math.sin(Math.toRadians(this.yaw));
        float zOffset = distance * (float) Math.cos(Math.toRadians(this.yaw));
        this.position.x -= xOffset;
        this.position.z += zOffset;
    }
    
    // Move camera backward
    public void backward(float distance) {
        float xOffset = distance * (float) Math.sin(Math.toRadians(this.yaw));
        float zOffset = distance * (float) Math.cos(Math.toRadians(this.yaw));
        this.position.x += xOffset;
        this.position.z -= zOffset;
    }
    
    // Move left
    public void left(float distance) {
        float xOffset = distance * (float) Math.sin(Math.toRadians(this.yaw-90));
        float zOffset = distance * (float) Math.cos(Math.toRadians(this.yaw-90));
        this.position.x -= xOffset;
        this.position.z += zOffset;
    }
    
    // Move right
    public void right(float distance) {
        float xOffset = distance * (float) Math.sin(Math.toRadians(this.yaw+90));
        float zOffset = distance * (float) Math.cos(Math.toRadians(this.yaw+90));
        this.position.x -= xOffset;
        this.position.z += zOffset;
    }
    
    // Move up
    public void up(float distance) { this.position.y -= distance; }
    
    // Move down
    public void down(float distance) { this.position.y += distance; }
    
    // Looks through the camera
    public void lookThrough() {
        glRotatef(this.pitch, 1.0f, 0.0f, 0.0f); // pitch around x-axis
        glRotatef(this.yaw, 0.0f, 1.0f, 0.0f); // yaw around y-axis
        glTranslatef(this.position.x, this.position.y, this.position.z); // translate pitch vector
    }
    
    // Take input
    public void readControls() {
        // Mouse inputs        
        float dx = Mouse.getDX();
        float dy = Mouse.getDY();
        
        this.yaw(dx * this.mouseSensitivity);
        this.pitch(dy * this.mouseSensitivity);
        
        // Keyboard inputs
        if (Keyboard.isKeyDown(Keyboard.KEY_W))
            this.forward(this.movementSpeed);
        
        if (Keyboard.isKeyDown(Keyboard.KEY_S))
            this.backward(this.movementSpeed);
        
        if (Keyboard.isKeyDown(Keyboard.KEY_A))
            this.left(this.movementSpeed);
        
        if (Keyboard.isKeyDown(Keyboard.KEY_D))
            this.right(this.movementSpeed);
        
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
            this.up(this.movementSpeed);
        
        if (Keyboard.isKeyDown(Keyboard.KEY_E))
            this.down(this.movementSpeed);
        
        this.lookThrough();
    }
}
