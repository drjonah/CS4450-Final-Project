
package finalproject;

// Open GL
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Jonah & Michael
 */
public class Cube {
    
    // Position
    float positionX;
    float positionY;
    float positionZ;
    
    // Config
    int size;
    
    // Constructor
    public Cube() {}
    
    public Cube(float x, float y, float z, int s) {
        this.positionX = x;
        this.positionY = y;
        this.positionZ = z;
        this.size = s;
    }
    
    // Render the cube
    public void render() {
        // Front face
        glBegin(GL_QUADS);
        glColor3f(0.0f, 0.0f, 1.0f);  // Blue color
        glVertex3f(positionX, positionY, positionZ);
        glVertex3f(positionX + size, positionY, positionZ);
        glVertex3f(positionX + size, positionY + size, positionZ);
        glVertex3f(positionX, positionY + size, positionZ);
        glEnd();
    
        // Back face
        glBegin(GL_QUADS);
        glColor3f(1.0f, 0.0f, 0.0f);  // Red color
        glVertex3f(positionX, positionY, positionZ + size);
        glVertex3f(positionX + size, positionY, positionZ + size);
        glVertex3f(positionX + size, positionY + size, positionZ + size);
        glVertex3f(positionX, positionY + size, positionZ + size);
        glEnd();
    
        // Left face
        glBegin(GL_QUADS);
        glColor3f(0.0f, 1.0f, 0.0f);  // Green color
        glVertex3f(positionX, positionY, positionZ);
        glVertex3f(positionX, positionY, positionZ + size);
        glVertex3f(positionX, positionY + size, positionZ + size);
        glVertex3f(positionX, positionY + size, positionZ);
        glEnd();
    
        // Right face
        glBegin(GL_QUADS);
        glColor3f(1.0f, 1.0f, 0.0f);  // Yellow color
        glVertex3f(positionX + size, positionY, positionZ);
        glVertex3f(positionX + size, positionY, positionZ + size);
        glVertex3f(positionX + size, positionY + size, positionZ + size);
        glVertex3f(positionX + size, positionY + size, positionZ);
        glEnd();
    
        // Top face
        glBegin(GL_QUADS);
        glColor3f(1.0f, 0.0f, 1.0f);  // Magenta color
        glVertex3f(positionX, positionY + size, positionZ);
        glVertex3f(positionX + size, positionY + size, positionZ);
        glVertex3f(positionX + size, positionY + size, positionZ + size);
        glVertex3f(positionX, positionY + size, positionZ + size);
        glEnd();
    
        // Bottom face
        glBegin(GL_QUADS);
        glColor3f(0.0f, 1.0f, 1.0f);  // Cyan color
        glVertex3f(positionX, positionY, positionZ);
        glVertex3f(positionX + size, positionY, positionZ);
        glVertex3f(positionX + size, positionY, positionZ + size);
        glVertex3f(positionX, positionY, positionZ + size);
        glEnd();
    }

}
