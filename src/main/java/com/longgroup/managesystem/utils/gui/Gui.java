package com.longgroup.managesystem.utils.gui;

import cn.hutool.core.img.Img;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @Class: Gui
 * @Description: Gui$
 * @title: Gui
 * @Author qlh
 * @Date: 2020/7/28 12:41
 * @Version 1.0
 */
public class Gui {
    //目标集合fileList
    private static ArrayList<File> fileList = new ArrayList<File>();
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\网站壁纸\\1.jpg");
        BufferedImage read = ImageIO.read(file);
        // 1. 创建一个顶层容器（窗口）
        // 创建窗口
        JFrame jf = new JFrame();
        //设置窗口标题
        jf.setTitle("齐龙辉");
        jf.setIconImage(read);
        // 设置窗口大小
//        jf.setSize(250, 250);
        jf.setSize(new Dimension(500,500));
        // 当点击窗口的关闭按钮时退出程序（没有这一句，程序不会退出）
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 设置窗口是否可放大缩小
        jf.setResizable(true);
        // 把窗口位置设置到屏幕中心
        jf.setLocationRelativeTo(null);


        // 2. 创建中间容器（面板容器）
        // 创建面板容器，使用默认的布局管理器
        JPanel panel = new JPanel();

        // 创建文本区域, 用于显示相关信息
        final JTextArea msgTextArea = new JTextArea(10, 40);
        msgTextArea.setLineWrap(true);
        panel.add(msgTextArea);

        // 3. 创建一个基本组件（按钮），并添加到 面板容器 中
        JButton openBtn = new JButton("打开");
        openBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFileOpenDialog(jf, msgTextArea);
            }
        });
        panel.add(openBtn);

        JButton saveBtn = new JButton("保存");
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFileSaveDialog(jf, msgTextArea);
            }
        });
        panel.add(saveBtn);
        jf.setContentPane(panel);
        jf.setVisible(true);
    }

    private static void showFileSaveDialog(Component parent, JTextArea msgTextArea) {
        // 创建一个默认的文件选取器
        JFileChooser fileChooser = new JFileChooser();

        // 设置打开文件选择框后默认输入的文件名
        fileChooser.setSelectedFile(new File("测试文件.zip"));

        // 打开文件选择框（线程将被阻塞, 直到选择框被关闭）
        int result = fileChooser.showSaveDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {
            // 如果点击了"保存", 则获取选择的保存路径
            File file = fileChooser.getSelectedFile();
            msgTextArea.append("保存到文件: " + file.getAbsolutePath() + "\n\n");
        }
    }

    private static void showFileOpenDialog(Component parent, JTextArea msgTextArea){
        // 创建一个默认的文件选取器
        JFileChooser fileChooser = new JFileChooser();
        // 设置默认显示的文件夹为当前文件夹 .表示当前文件夹
        fileChooser.setCurrentDirectory(new File("e:\\"));
        // 设置文件选择的模式（只选文件、只选文件夹、文件和文件均可选）
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // 设置是否允许多选
        fileChooser.setMultiSelectionEnabled(true);
        // 添加可用的文件过滤器（FileNameExtensionFilter 的第一个参数是描述, 后面是需要过滤的文件扩展名 可变参数）
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("zip(*.zip, *.rar)", "zip", "rar"));
        // 设置默认使用的文件过滤器
        fileChooser.setFileFilter(new FileNameExtensionFilter("image(*.jpg, *.png, *.gif)", "jpg", "png", "gif"));
        // 打开文件选择框（线程将被阻塞, 直到选择框被关闭）
        int result = fileChooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            // 如果点击了"确定", 则获取选择的文件路径
            //File file = fileChooser.getSelectedFile();

            // 如果允许选择多个文件, 则通过下面方法获取选择的所有文件
             File[] files = fileChooser.getSelectedFiles();
             fileList = recursiveFolderToGetFiles(files);
            for (File file : fileList) {
                msgTextArea.append("打开文件: " + file.getAbsolutePath() + "\n\n");
            }
            /*for (File file : files) {
                msgTextArea.append("打开文件: " + file.getAbsolutePath() + "\n\n");
            }*/
        }
    }
    public static void cropPictures(ArrayList<File> fileArrayList) throws IOException {
        if (!fileArrayList.isEmpty()) {
            for (File imgFile : fileArrayList) {
                // 读取图片
                BufferedImage bufImage = ImageIO.read(imgFile);
                // 获取图片的宽高
                final int width = bufImage.getWidth();
                final int height = bufImage.getHeight();
                Img cut = Img.from(imgFile).cut(new Rectangle(0, 0, width, height - 150));
                cut.write(imgFile);
            }
        }
    }
    public static void recursiveFolderToGetFiles(String... dirPth) throws IOException {
        //目标集合fileList
        ArrayList<File> fileList = new ArrayList<File>();
        if (dirPth.length > 0) {
            for (String path : dirPth) {
                System.out.println(path);
                File file = new File(path);
                if (file.isDirectory()) {
                    File[] files = file.listFiles();
                    for (File fileIndex : Objects.requireNonNull(files)) {
                        if(fileIndex.isDirectory()){
                            recursiveFolderToGetFiles(fileIndex.getPath());
                        }else {
                            fileList.add(fileIndex);
                        }
                    }
                }else {
                    String filePath = file.getPath();
                    fileList.add(new File(filePath));
                }
            }
        }
        cropPictures(fileList);
    }
    public static ArrayList<File> recursiveFolderToGetFiles(File... files){
        //目标集合fileList
        ArrayList<File> fileList = new ArrayList<File>();
        if (files.length > 0) {
            for (File file : files) {
                System.out.println(file);
                if (file.isDirectory()) {
                    File[] fileLists = file.listFiles();
                    for (File fileIndex : Objects.requireNonNull(fileLists)) {
                        if (fileIndex.isDirectory()) {
                            recursiveFolderToGetFiles(fileIndex);
                        } else {
                            fileList.add(fileIndex);
                        }
                    }
                } else {
                    fileList.add(file);
                }
            }
        }
        return fileList;
    }
}
