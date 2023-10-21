
# AddonBlankCreator

Simple module blank creator for Cart-Power developers.
>_«**Sic Parvis Magna**» - «Great things have small beginnings» (c) Francis Drake_

## 📃Features
- Checks for permission to write to a folder.
  - if there is no write permission, the program ends.
- Allows you to set the module id via the console before creating it.
- Allows you to change the module id via the console before creating it.
- Creates module folders to which files will be added.
- Creates an addon.xml file (addon scheme="3.0").
- Adds a module icon.
- Adds language variable files for EN and RU languages.
- Statically specified data is used as the name and description of the module in EN and RU languages.

## 📸Screenshots
If you don't have write permissions:
![Write permissions checking](https://awesomescreenshot.s3.amazonaws.com/image/3632808/43726559-bb8676973137e7b2f5f1ee75411d4bf4.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAJSCJQ2NM3XLFPVKA%2F20231021%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20231021T103319Z&X-Amz-Expires=28800&X-Amz-SignedHeaders=host&X-Amz-Signature=67806140920d3a5da4c00fe2f2746c0be3bbb5c734c816795b73bc4bd90c6461)
Creation steps:
![Creation steps](https://awesomescreenshot.s3.amazonaws.com/image/3632808/43726460-3bef7ab47b5218dfa2f5cb7592b08b2d.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAJSCJQ2NM3XLFPVKA%2F20231021%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20231021T101942Z&X-Amz-Expires=28800&X-Amz-SignedHeaders=host&X-Amz-Signature=d09e20a3685225d9ddc945dc18126c22968068e1824b24ea8ba6462abfeb595b)
Folder structure:
<br>![Folder structure](https://awesomescreenshot.s3.amazonaws.com/image/3632808/43726482-809123b71a03a665b5105f68a8964002.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAJSCJQ2NM3XLFPVKA%2F20231021%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20231021T102049Z&X-Amz-Expires=28800&X-Amz-SignedHeaders=host&X-Amz-Signature=743bc31dedf6030649c0b4bd2bd460fb52865cb2fc0465cb474a883c058f5518)

addon.xml example:
```xml
<?xml version="1.0"?>
<addon scheme="3.0">
    <id>cp_test</id>
    <version>1.0</version>
    <priority>5000</priority>
    <position>100</position>
    <status>disabled</status>
    <default_language>en</default_language>
    <has_icon>Y</has_icon>
    <authors>
        <author>
            <name>Cart-Power</name>
            <email>sales@cart-power.com</email>
            <url>https://cart-power.com</url>
        </author>
    </authors>
    <supplier>Cart-Power</supplier>
    <supplier_link>https://cart-power.com</supplier_link>
</addon>
```
EN language variable file example:
```bash
msgid ""
msgstr "Project-Id-Version: tygh"
"Content-Type: text/plain; charset=UTF-8\n"
"Language-Team: English\n"
"Language: en_US\n"

msgctxt "Addons::name::cp_test"
msgid "Cart-Power: Blank addon name"
msgstr "Cart-Power: Blank addon name"

msgctxt "Addons::description::cp_test"
msgid "Blank description of the addon. Developed by <a target=\"_blank\" href=\"https://cart-power.com/\">Cart-Power</a>"
msgstr "Blank description of the addon. Developed by <a target=\"_blank\" href=\"https://cart-power.com/\">Cart-Power</a>"
```
RU language variable file example:
```bash
msgid ""
msgstr "Project-Id-Version: tygh"
"Content-Type: text/plain; charset=UTF-8\n"
"Language-Team: Russian\n"
"Language: ru_RU\n"

msgctxt "Addons::name::cp_test"
msgid "Cart-Power: Заготовка имени модуля"
msgstr "Cart-Power: Заготовка имени модуля"

msgctxt "Addons::description::cp_test"
msgid "Blank description of the addon. Developed by <a target=\"_blank\" href=\"https://cart-power.com/\">Cart-Power</a>"
msgstr "Заготовка описания модуля. Разработано <a target=\"_blank\" href=\"https://cart-power.ru/\">Cart-Power</a>
```

## 🛠Requirements 

[![java21](https://img.shields.io/badge/Language-Java%2021+-green)](https://www.oracle.com/java/technologies/downloads/#java21)


## ⚙Installation & Run Locally

Clone the project

```bash
  git clone https://github.com/shakowsx/AddonBlankCreator
```

Go to the project directory

```bash
  cd AddonBlankCreator 
```

Install project with mvn

```bash
  mvn install
```

Start the app
```bash
  java -jar target/AddonBlankCreator-1.0-SNAPSHOT.jar 
```
 
## 🎓Lessons Learned

What did I learn while building this project?
- Improved understanding of creating project structure.
- Improved understanding of Java code formatting rules (see [Code Conventions for the Java Programming Language]).
- Familiarized yourself with using interfaces (see [Java Language Specification - Chapter 9. Interfaces], [The Java™ Tutorials]).
- Familiarized yourself with `HashMap` and `BufferedWriter` (see [HashMap], [BufferedWriter]).
- Familiarized yourself with copying data from application resources (see [Class InputStream],[Location-Independent Access to Resources]).
- Learned about text blocks and their uses (see [Programmer's Guide to Text Blocks]).

What challenges did I face and how did I overcome them?
- Copying a file from the application archive (solved via InputStream).
- Formation of data for subsequent recording of a file (solved through text blocks, although it could be done through a separate file)
- Problems with incorrectly entered data when reading data in the console (solved using replaceAll and toLowerCase)
## ✒Authors

- [Евгений Рябов aka @Shako](https://www.github.com/shakowsx)

[Code Conventions for the Java Programming Language]: <https://www.oracle.com/java/technologies/javase/codeconventions-codeexamples.html>
[The Java™ Tutorials]: <https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html>
[Java Language Specification - Chapter 9. Interfaces]: <https://docs.oracle.com/javase/specs/jls/se17/html/jls-9.html>
[HashMap]: <https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html>
[BufferedWriter]: <https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/BufferedWriter.html>
[Location-Independent Access to Resources]: <https://docs.oracle.com/javase/8/docs/technotes/guides/lang/resources.html>
[Class InputStream]: <https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/InputStream.html>
[Programmer's Guide to Text Blocks]: <https://docs.oracle.com/en/java/javase/21/text-blocks/index.html>