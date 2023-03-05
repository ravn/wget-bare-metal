# wget-bare-metal

## 2009 

I worked for nine years as a Java developer in an agile Cobol company, writing the stuff that was hard to do in the OPM Cobol environment on the AS/400 platform.  

This was typically interfacing to other systems, either directly over the internet or by handling incoming and outgoing data packets, usually in the form of XML documents.

The AS/400 is a midrange IBM system, which was intended to be the successor to the big mainframe systems - this didn't catch on - and where the IBM strategy at the time was "Let's go to Java everywhere".  Java was created in a Unix company, which is fine for Linux, Windows and AIX, but was a rather bad fit for a platform where you are not even guaranteed that you have a console device or that the TCP/IP network stack is up.   This became better over the years, but for a very long time it was not uncommon for me to have to get software on a new system where the only tool available for this on the command line was the FTP command which is not very good with web-sites.  Oh, yes, and the JDK which is!

So, I wrote a small download snippet in Java 5-6-ish which was small enough that it fit on a single page in the editor, so it could be pasted in in one go.  Then save it, compile it and run it, and THEN start downloading the things I needed.

See https://thorbjoernsstuff.blogspot.com/2009/10/simplest-possible-wgetcurl-downloader.html for my original writeup back in 2009.

The 17 lines of code is in [src/main/java/Get.java](src/main/java/Get.java).

## 2023

I came by my old blog entry accidentially and thought "Hmmm, wonder how small I could write it today in Java 17?"

Turned out it could get down to 9 lines (three being closing brackets), using three things:

* Try-with-resources handles the `close()`-calls nice and easy.  This is really a nice addition.
* `var` statements make the declarations shorter without much loss of context.
* Inlining package names allows the removal of import statements.

Source at
[src/main/java/Get17.java](src/main/java/Get17.java).

Also the single-file source code programs launcher introduced in Java 11 with https://openjdk.org/jeps/330 mean that we can run it directly without having to run javac manually first

```sh
% java Get17.java https://www.helloworld.org/data/helloworld.py output.txt
https://www.helloworld.org/data/helloworld.py -> output.txt
% cat output.txt 
print('Hello World')
%
```