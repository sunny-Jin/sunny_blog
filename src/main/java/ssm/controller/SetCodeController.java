package ssm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

@Controller
@RequestMapping("/SetCode")
public class SetCodeController {
    @RequestMapping("/generate.do")
    public void generate(HttpServletRequest req, HttpServletResponse response, HttpSession session) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String code = drawImg(outputStream);
        session.setAttribute("SESSION_CODE", code);
        try {
            ServletOutputStream out = response.getOutputStream();
            response.setContentType("jpg");
            response.setHeader("Cache-Control", "no-cache");
            outputStream.writeTo(out);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String drawImg(ByteArrayOutputStream outputStream) {
        String code = "";
        for (int i = 0; i < 4; i++) {
            code = code + RandomChar();
        }

        int width = 70;
        int height = 25;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        Font font = new Font("Time New Roman", Font.PLAIN, 20);
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
        Color color = new Color(66, 2, 82);
        g.setColor(color);
        g.setBackground(new Color(226, 226, 240));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        java.awt.geom.Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);
        g.dispose();
        try {
            ImageIO.write(bi, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return code;
    }

    /*
    * 随机参数一个字符
    *
    * */
    public char RandomChar() {
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }
}
