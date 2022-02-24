package dev.yeff.orbital.renderer;

import static org.lwjgl.opengl.GL11.*;

public class Renderer {
    public void renderGameObject(GameObject object) {
        object.use();

        glDrawElements(GL_TRIANGLES, object.getElementArray().length, GL_UNSIGNED_INT, 0);
    }
}
