package dev.yeff.examples.scenes;

import dev.yeff.orbital.Scene;
import dev.yeff.orbital.Window;
import dev.yeff.orbital.io.KeyListener;
import dev.yeff.orbital.renderer.GameObject;
import dev.yeff.orbital.renderer.Renderer;
import dev.yeff.orbital.renderer.Shader;
import org.lwjgl.BufferUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class MainScene implements Scene {
    private static Logger LOGGER = LoggerFactory.getLogger(MainScene.class);

    private Shader shader;
    private GameObject object;
    private Renderer renderer;

    private float[] vertexArray = {
            // vertices                // colors
            0.5f, -0.5f,  0.0f,        1.0f, 0.0f, 0.0f, 1.0f, // bottom right
            -0.5f, 0.5f,  0.0f,        0.0f, 1.0f, 0.0f, 1.0f, // top left
            0.5f,  0.5f,  0.0f,        0.0f, 0.0f, 1.0f, 1.0f, // top right
            -0.5f, -0.5f, 0.0f,        1.0f, 1.0f, 1.0f, 1.0f, // top left
    };


    // IMPORTANT: Must be in counter-clockwise order
    private int[] elementArray = {
            2, 1, 0,
            0, 1, 3
    };


    @Override
    public void init(Window window) {
        LOGGER.info("initialized");

        // Get renderer from the window
        renderer = window.getRenderer();

        // Create and compile the shader
        shader = new Shader("examples/src/assets/shaders/default.glsl");
        shader.compile();

        // Create the object
        object = new GameObject(vertexArray, elementArray, shader);
        object.create();
    }

    @Override
    public void update(Window window, float delta) {
        if (KeyListener.isKeyDown(GLFW_KEY_ESCAPE))
            System.exit(0);

        renderer.renderGameObject(object);
    }

    @Override
    public void dispose(Window window) {
        object.dispose();
        shader.detach();
    }
}