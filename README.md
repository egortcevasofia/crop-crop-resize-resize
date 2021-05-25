### Консольная утилита позволяет обрабатывать изображения форматов jpg, png.

### После команд clean build запустить jar файл в папке target в соответствии с интерфейсом взаимодействия.

### Интерфейс взаимодействия:
```bash
java -jar crop-crop-resize-resize-1.0-SNAPSHOT-jar-with-dependencies.jar -h
Available formats: jpeg, png
order of options: --resize, --quality, -crop, --blur
Usage: convert [-hV] [-b=radius] [-c="width height x y"] [-f=jpg/png]
               [-q=value] [-r="width height"] input-file output-file
      input-file         AbsolutePath to file or name of file, if it is in
                           current directory
      output-file        AbsolutePath to file or name of file, if it is must be
                           saved in current directory
  -b, --blur=radius      add blur
  -c, --crop="width height x y"
                         cuts out a rectangular area of the image with width
                           and height from point (x, y)
  -f, --format=jpg/png   converts image to JPEG / PNG
  -h, --help             Show this help message and exit.
  -q, --quality=value    set the compression level for JPEG / PNG files; from 1
                           (lowest quality) to 100 (best quality)
  -r, --resize="width height"
                         reduces, increases an image or set new size
  -V, --version          Print version information and exit.
  ```

*Используемые библиотеки: picocli для с командной строкой, marvin для обработки изображений, junit для написания тестов.*
