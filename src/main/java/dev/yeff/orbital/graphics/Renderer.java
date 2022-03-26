package dev.yeff.orbital.graphics;

import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.resources.TextFont;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

/**
 * Class providing functionality to render different shapes, text and {@code Sprite}'s.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class Renderer {
    /**
     * Draws a {@code Sprite} to the screen at a given position.
     *
     * @param sprite The sprite to draw.
     * @param pos The position to draw it at.
     */
    public void drawTexture(Sprite sprite, Vector2f pos) {
        DrawTexture(sprite.getRawTex(), (int) pos.x, (int) pos.y, RAYWHITE);
    }

    /**
     * Draws a circle at a given position.
     *
     * @param color The color of the circle.
     * @param pos The position to draw the circle at.
     * @param radius The radius of the circle.
     */
    public void drawCircle(Colors color, Vector2f pos, float radius) {
        DrawCircle((int) pos.x, (int) pos.y, radius, color.getColor());
    }

    /**
     * Draws an outline of a circle at a given position.
     *
     * @param color The color of the outline.
     * @param pos The position to draw the circle outline at.
     * @param radius The radius of the circle.
     */
    public void drawCircleOutline(Colors color, Vector2f pos, float radius) {
        DrawCircleLines((int) pos.x, (int) pos.y, radius, color.getColor());
    }

    /**
     * Draws a rectangle at a given position.
     *
     * @param color The color of the rectangle.
     * @param pos The position to draw the rectangle at.
     * @param size The width and height of the rectangle.
     */
    public void drawRect(Colors color, Vector2f pos, Vector2f size) {
        DrawRectangle((int) pos.x, (int) pos.y, (int) size.x, (int) size.y, color.getColor());
    }

    /**
     * Draws a rectangle at a given position.
     *
     * @param color The color of the rectangle.
     * @param pos The position to draw the rectangle at.
     * @param size The size of the rectangle.
     */
    public void drawRect(Colors color, Vector2f pos, float size) {
        DrawRectangle((int) pos.x, (int) pos.y, (int) size, (int) size, color.getColor());
    }

    /**
     * Draws an outline of a rectangle at a given position.
     *
     * @param pos The position of the rectangle outline at.
     * @param size The width and height of the rectangle.
     * @param color The color of the outline.
     */
    public void drawRectOutline(Vector2f pos, Vector2f size, Colors color) {
        DrawRectangleLines((int) pos.x, (int) pos.y, (int) size.x, (int) size.y, color.getColor());
    }

    /**
     * Draws an outline of a rectangle at a given position.
     *
     * @param pos The position of the rectangle outline at.
     * @param size The size of the rectangle.
     * @param color The color of the outline.
     */
    public void drawRectOutline(Vector2f pos, float size, Colors color) {
        DrawRectangleLines((int) pos.x, (int) pos.y, (int) size, (int) size, color.getColor());
    }

    /**
     * Draws a straight line from a given starting and ending point.
     *
     * @param start The starting point of the line.
     * @param end The ending point of the line.
     * @param color The color of the line.
     */
    public void drawLine(Vector2f start, Vector2f end, Colors color) {
        DrawLine((int) start.x, (int) start.y, (int) end.x, (int) end.y, color.getColor());
    }

    /**
     * Draws a straight line from a given starting and ending point, with a thickness.
     *
     * @param start The starting point of the line.
     * @param end The ending point of the line.
     * @param color The color of the line.
     * @param thickness The thickness of the line.
     */
    public void drawLine(Vector2f start, Vector2f end, Colors color, float thickness) {
        DrawLineEx(start.asRaylibVector(), end.asRaylibVector(), thickness, color.getColor());
    }

    /**
     * Draws a string at a given position, with a font size.
     *
     * @param text The string to draw.
     * @param fontSize The font size of the text.
     * @param pos The position to draw the text at.
     */
    public void drawString(String text, float fontSize, Vector2f pos) {
        DrawText(text, (int) pos.x, (int) pos.y, (int) fontSize, Colors.BLACK.getColor());
    }

    /**
     * Draws a string at a given position, with a font and font size.
     *
     * @param text The string to draw.
     * @param fontSize The font size of the text.
     * @param pos The position to draw the text at.
     * @param font The font to draw the text with.
     */
    public void drawString(String text, float fontSize, Vector2f pos, TextFont font) {
        DrawTextEx(font.asRaylibFont(), text, pos.asRaylibVector(), fontSize, 2, Colors.BLACK.getColor());
    }

    /**
     * Fills the background with a given color.
     *
     * @param color The color to fill with.
     */
    public void fillBackground(Colors color) { ClearBackground(color.getColor()); }
}