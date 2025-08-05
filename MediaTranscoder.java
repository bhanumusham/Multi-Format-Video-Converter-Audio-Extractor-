import java.io.IOException;
import java.util.Scanner;
public class MediaTranscoder {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Video name present in current dirctory");
        String inputFilePath = s.next();      // Replace with your input video file path
        System.out.println("Enter name to name the output file");
        String outputFilePath = s.next();    // Replace with your desired output file path
        System.out.println("Enter output format");
        // FFmpeg command to transcode video to MP3
        String[] ffmpegCommandmp3 = {
            "ffmpeg",
            "-i", inputFilePath,
            "-vn",                  // Disable video
            "-acodec", "mp3",       // Audio codec: MP3
            "-q:a", "2",            // Audio quality (0 - highest, 9 - lowest)
           outputFilePath+".mp3"
        };
        String[] ffmpegCommandh264 = {
            "ffmpeg",
            "-i", inputFilePath,
            "-c:v", "libx264",      // Video codec: H.264 (libx264)
            "-crf", "23",           // Constant Rate Factor (lower value means higher quality)
            "-preset", "medium",    // Preset for encoding speed vs. compression efficiency
            "-c:a", "aac",          // Audio codec: AAC
            "-b:a", "128k",         // Audio bitrate
            outputFilePath+".mp4"
        };
        String[] ffmpegCommandavi = {
            "ffmpeg",
            "-i", inputFilePath,
            "-c:v", "mpeg4",        // Video codec: MPEG-4
            "-q:v", "2",            // Video quality (0 - highest, 31 - lowest)
            "-c:a", "copy",         // Copy audio codec
            outputFilePath+".avi"
        };
        String[] ffmpegCommandacc = {
            "ffmpeg",
            "-i", inputFilePath,
            "-vn",                  // Disable video
            "-c:a", "aac",          // Audio codec: AAC
            "-b:a", "128k",         // Audio bitrate
            outputFilePath+".aac"
        };
        String[] ffmpegCommandMkv = {
            "ffmpeg",
            "-i", inputFilePath,
            "-c:v", "copy",         // Copy video codec
            "-c:a", "copy",         // Copy audio codec
            outputFilePath+".mkv"
        };
        System.out.println("Select output format \n1. MP3 \n2. AAC \n3. H.264\n4. AVI\n5. MKV");
        int choice = s.nextInt();
        switch(choice){
            case 1:
                Transcoder.transcode(ffmpegCommandmp3);
                break;
            case 2:
                Transcoder.transcode(ffmpegCommandacc);
                break;
            case 3:
                Transcoder.transcode(ffmpegCommandh264);
                break;
            case 4:
                Transcoder.transcode(ffmpegCommandavi);
                break;
            case 5:
                Transcoder.transcode(ffmpegCommandMkv);
                break;
            default:
                System.out.println("Enter a Vaild option");
        }
        s.close();
    }
}

class StreamGobbler implements Runnable {
    private java.io.InputStream inputStream;

    public StreamGobbler(java.io.InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void run() {
        java.util.Scanner scanner = new java.util.Scanner(inputStream);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
class Transcoder{
    public static void transcode(String []ffmpegCommand){
        try {
            Process process = new ProcessBuilder(ffmpegCommand).redirectErrorStream(true).start();
            // Print FFmpeg console output
            StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream());
            new Thread(streamGobbler).start();

            int exitCode = process.waitFor();
            System.out.println("FFmpeg process exited with code " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}