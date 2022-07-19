package alura_stickers_maven;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {
    public void generate(String name, String text, InputStream input) throws Exception {
        // Lê uma imagem a partir da url da imagem
        BufferedImage image = ImageIO.read(input);

        // Cria uma nova imagem com transparência
        int width = image.getWidth();
        int height = image.getHeight();
        int newHeight = height + 200;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // Cria nova imagem em memória
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(image, 0, 0, null);

        // Configurando nova fonte
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 100);

        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);

        // Escreve uma frase na imagem
        int drawY = newImage.getHeight() - 100;
        int drawX = 100;

        graphics.drawString(text, drawX, drawY);

        // Salva a nova imagem em um arquivo
        ImageIO.write(newImage, "png", new File("static/" + name + ".png"));
    }
}
