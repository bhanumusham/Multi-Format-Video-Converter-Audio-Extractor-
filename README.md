# 🎥 Media Transcoding Tool (Java + FFmpeg)

The Java Video Converter and Audio Extractor project leverages FFMPEG to provide efficient   conversion of video files 
into various formats and extract high-quality audio tracks. 
A simple, interactive Java program that enables users to transcode media files into different formats (MP3, AAC, MP4/H.264, AVI, MKV) using FFmpeg. Built as part of a course-based project at **GRIET, Hyderabad**.

---

## 📌 Project Overview

Media transcoding is the process of converting multimedia files (audio/video) from one format to another. This project provides a basic yet functional command-line interface in Java to allow users to:

* Select an input video
* Choose the desired output format
* Execute FFmpeg commands through Java
* Monitor the transcoding process in real-time

---

## 🎯 Features

* ✅ Convert video/audio to MP3, AAC, MP4 (H.264), AVI, and MKV
* ✅ FFmpeg integration via Java ProcessBuilder
* ✅ Real-time console output monitoring
* ✅ Streamlined CLI interface
* ✅ Platform-independent (Java + FFmpeg required)

---

## 📷 Demo

> Add these after running your app and capturing outputs

![Sample Console UI](assets/demo_console.png)
![Output Files](assets/output_files.png)

---

## 🛠️ Technologies Used

* **Java 17+**
* **FFmpeg**
* **ProcessBuilder**
* **Multithreading (for console output)**

---

## 🧑‍💻 How It Works

1. User is prompted for:

   * Input video name
   * Output filename
   * Desired format (MP3, AAC, H.264, AVI, MKV)
2. Java builds the appropriate FFmpeg command
3. The command is executed using `ProcessBuilder`
4. FFmpeg output is streamed in real-time using a `StreamGobbler` thread

---

## 💾 Sample Code Snippet

```java
String[] ffmpegCommandmp3 = {
  "ffmpeg", "-i", inputFilePath, "-vn", "-acodec", "mp3", "-q:a", "2", outputFilePath + ".mp3"
};

Transcoder.transcode(ffmpegCommandmp3);
```

> Full source code is available in the `MediaTranscoder.java` file.

---

## 📦 Output Formats Supported

| Format | Codec Used | File Extension |
| ------ | ---------- | -------------- |
| MP3    | MP3        | `.mp3`         |
| AAC    | AAC        | `.aac`         |
| H.264  | libx264    | `.mp4`         |
| AVI    | MPEG-4     | `.avi`         |
| MKV    | Copy       | `.mkv`         |

---

## 🧪 Test Cases
![image_alt](https://github.com/bhanumusham/Multi-Format-Video-Converter-Audio-Extractor-/blob/20efe0a47436916b3ddfad2fbe15fd9f1755ed67/Screenshot%20(56).png)


---

## 🐞 Common Errors & Fixes

| Error                | Cause                 | Solution                                 |
| -------------------- | --------------------- | ---------------------------------------- |
| `FileNotFound`       | Incorrect input path  | Ensure video is in the current directory |
| `Unsupported format` | Codec mismatch        | Use supported FFmpeg flags               |
| `Access denied`      | File permission issue | Run terminal with elevated permissions   |
| `Exit code != 0`     | FFmpeg error          | Review FFmpeg output in terminal         |

---

## 📈 Future Improvements

* GUI-based front-end (e.g., JavaFX or Swing)
* Batch processing for multiple files
* Progress bar integration
* File browser for input/output selection
* Integration with cloud storage

---

## 📚 References

* [FFmpeg Documentation](https://ffmpeg.org/documentation.html)
* *Core Java* – Cay S. Horstmann & Gary Cornell
* *Java: The Complete Reference* – Herbert Schildt

---
