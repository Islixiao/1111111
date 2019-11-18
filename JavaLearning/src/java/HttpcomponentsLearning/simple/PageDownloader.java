package HttpcomponentsLearning.simple;

/***Created by moyongzhuo
 *On 2017/9/26  ***14:15.
 ******/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

//本类用于将指定url对应的网页下载至本地一个文件。
public class PageDownloader {

    public static void downloadPageByGetMethod(String url) throws IOException {

        // 1、通过HttpGet获取到response对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 注意，必需要加上http://的前缀，否则会报：Target host is null异常。
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);

        InputStream is = null;
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            try {
                // 2、获取response的entity。
                HttpEntity entity = response.getEntity();

                // 3、获取到InputStream对象，并对内容进行处理
                is = entity.getContent();
                String fileName = getFileName(url);
                saveToFile("D:\\workspace\\java\\downloadsoources\\", fileName, is);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } finally {

                if (is != null) {
                    is.close();
                }
                if (response != null) {
                    response.close();
                }
            }
        }
    }

    //将输入流中的内容输出到path指定的路径，fileName指定的文件名
    private static void saveToFile(String path, String fileName, InputStream is) {
        Scanner sc = new Scanner(is);
        Writer os = null;
        try {
            os = new PrintWriter(path + fileName);
            while (sc.hasNext()) {
                os.write(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
            if (os != null) {
                try{
                    os.flush();
                    os.close();
                }catch(IOException e){
                    e.printStackTrace();
                    System.out.println("输出流关闭失败！");
                }
            }
        }
    }

    // 将url中的特殊字符用下划线代替
    private static String getFileName(String url) {
        url = url.substring(7);
        String fileName = url.replaceAll("[\\?:*|<>\"/]", "_") + ".html";
        return fileName;
    }
    public static void main(String args[]) throws IOException {
        PageDownloader pagedownload = new PageDownloader();
        InputStream is = null;
        String fileName=null;
        pagedownload.downloadPageByGetMethod("https://baike.baidu.com/item/HttpComponents/3360215?fr=aladdin");
      //  System.out.println("is1: "+is);
      //  System.out.println("Filename1: "+fileName);
       // pagedownload.getFileName("https://baike.baidu.com/item/HttpComponents/3360215?fr=aladdin");
       // System.out.println("is2: "+is);
      //  System.out.println("Filename2: "+fileName);
      //  pagedownload.saveToFile("D:\\workspace\\java\\downloadsoources\\",fileName,is);
    }
}

