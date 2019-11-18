package com.shana.house.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author xiana
 * @create 2019/11/12
 * @since 1.0.0
 */
@Service
public class UploadService {
    @Autowired
    FastFileStorageClient storageClient;

    public String upload(MultipartFile file){
        //1.验证文件是否为空
        BufferedImage bufferedImage= null;
        try {
            bufferedImage = ImageIO.read(file.getInputStream());
            if(bufferedImage==null){
                return null;
            }
            String fileName=file.getOriginalFilename();
            String extension=fileName.substring(fileName.lastIndexOf(".")+1);
            StorePath storePath=this.storageClient.uploadFile(file.getInputStream(),file.getSize(),extension,null);
            String path="http://116.62.218.239/"+storePath.getFullPath();
            System.out.println(path);
            return path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

