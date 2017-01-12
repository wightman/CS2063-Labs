# Lab 1
This lab will introduce the Android Studio IDE and Android project structure through the creation of a simple 'Hello World!' application that will run on emulated or physical devices.
#### Objectives
* familiarize IDE navigation
* introduce emulator, device creation
* introduce layout editor
* project structure breakdown, highlights
* console log, for debugging

#### Procedure
###### 1. Open Android Studio
* → Start a new Android Studio Project
* → Set Application name: Lab 1 Hello World
* → Company Domain: ca.unb.mobiledev, click Next

Take note of the Minimum SDK (Software Development Kit). This will be the SDK for which your apps will be compiled against. Android Studio will use this information to provide accurate auto-complete as well as provide warnings when your code is not appropriately targeting the set minimum SDK.

While you should target the most current version of the SDK, setting a minimum SDK allows you to get backward compatability with devices running older versions, allowing your application to run on a larger percentage of devices.
* → Select Basic Activity, click Next

###### 2. Customize the Activity
Take note of the default values on this screen. Your MainActivity will be the first activity to run when your application is launched. The **Layout Name**: field is the name associated with this main activity’s layout style. This **activity_main.xml** file will describe _how_ the activity should look in terms global design; toolbars, floating icons, dropdowns, etc. Another layout file, content_main.xml, will provide components specific to the needs of this activity; TextViews, EditText, Buttons, etcetera. This idea will be expounded on in the project structure breakdown.

* → Click Finish

###### 3. Hello world!
The IDE will now build the project structure and files based on your previous inputs. This may take a while, so watch the message bar on the bottom of the window to know when the creation is completed. Your application will open to a graphical user interface containing a drag-n-drop layout editor. On this window you can view your application name, Lab 1 Hello World appearing across the ActionBar/Toolbar. Also note a generic ‘Hello world!’ statement within the application body. If it doesn't immediately appear, you can click on the vertical "1:Progress" tab on the left-hand side of the IDE and then click on the activity.xml tab along the top.

###### 4. Android Studio Device Emulator
Android Studio comes equipped with built-in device emulators and options for emulating real world devices for testing the applications you develop, to ensure functionality is as you expect it across a range of device types.

To access these emulators, locate the Run menu along the File menu bar along the top of Android Studio and click Run ‘app’. You can also run the emulator by clicking the familiar green Play button along the icon toolbar. Run the application now; you’ll be presented with the Device Chooser screen. From here you can decide to run your application on a physical device, if attached and running for developer mode, or to Launch emulator.

Select Launch emulator and click the ellipsis for further options. This window shows your currently available virtual devices. From this screen you can also create new virtual devices by selecting from a list of popular device models, API system images, and other hardware settings such as how to model front/back cameras, available memory, etcetera.

For now we’ll be using a Nexus 5 emulated on system image API 23. If that device does not yet exist in your list, go ahead and create it now then run the emulator. A tip regarding the emulator; once you've ran it for the first time during your login session, leave it open. Android Studio will use the already running instance to reflect new image states, saving you the initial startup times of the emulator loading itself into memory.

###### 5. Running From Device
_Unlocking Developer Mode for Device:_

Navigate to your device Settings menu, find About Device,  locate the Build number and click it (7) times. You will receive notice that dev mode has been unlocked. Navigate back one menu to About Device; access the new Developer options menu and turn on USB debugging.

With Android Studio open, attach via USB cable an Android device to your workstation. On your device, press OK to allow USB debugging. Run the application again; you will be presented with the Choose Device screen. Ensure your device is selected and click OK.

###### 6. Layout Editor
→ If you’ve navigated away from the layout editor, click the Project tab along the far left side of Android Studio, navigate to and double click res/layout/content_main.xml in the project structure.

→ Click the 'Hello world!' text in the application window preview. The text field, which is an Android object called TextView that we’ll learn more about later, is highlighted.

→ Take note of the Properties scroll window that populates to the right. From this toolbar Android View objects can be customized.

→ In Properties:

* locate the ```layout:centerInParent``` attribute. Set to “both”.
* locate the ```layout:width``` attribute. Set to “fill_parent”.
* locate the ```background``` attribute. Click the [...] to open the Resources menu. Click the Color tab. Use the color wheel to select a background color of your choice. Click OK.
* locate the ```gravity``` attribute. Click the arrow for dropdown gravity attribute options. Select “center_horizontal”.
* locate the ```textColor``` attribute. Click the [...] to open the Resources menu. Click the Color tab. Use the color wheel to select a text color of your choice. Click OK.
* locate the ```textSize``` attribute. Enter '22sp' and hit enter. 'sp' signifies a scale-independent pixel. This is a convenient way to size fonts in Android that will ensure it stays looking good on a variety of device screens. Fonts you'll always want to use 'sp', for other objects you will want 'px' or density-independent pixels 'dp'. For more information read the [Dimension descriptions in the Android API Guide](http://developer.android.com/guide/topics/resources/more-resources.html#Dimension)
* locate the textStyle attribute. Click the arrow for dropdown textStyle attribute options. Select “bold” and "italic".

Finally, we won't be needing the floating mail icon so go ahead and select it and delete it from the view. You can't delete it from the content_main.xml file however, you'll have to navigate to /layout/activity_main.xml and remove it there. That is because it's considered a global layout element for this activity.

If you access the Text tab at the bottom-left of the layout editor you can locate an XML line in activity_main that states ```<include layout=@layout/content_main"/>```. This tells the build process to factor in the content_main.xml layout contents into main's own. This is a new design pattern in Android, recently introduced with Android Studio 1.4. Many of these separation-of-concern style design patterns exist in the Android project structure and Android SDK.

Also note in the activity_main.xml Text tab that the entire layout you see in the layout editor appears described in XML. The same is true for content_main.xml. This provides two ways to work on Activity layouts.

Because we've removed the FloatingActionButton in our layout, let's go ahead and remove the code pertaining to this button from our ```onCreate()``` method. Find these lines and delete them.

```java
FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
```

Run the application by emulator once again and you’ll see the changes you’ve made reflected.

**1. Deliverable**
Take a screenshot of the emulator and save to verify your work.

###### 7. Project Structure
We will now take a look at what every Android Studio project structure has in common to develop an understanding of how this folder structure is navigated and how each piece ties together.

More information about the project structure can be found at [https://developer.android.com/tools/projects/index.html#ProjectFiles](https://developer.android.com/tools/projects/index.html#ProjectFiles)

→ Project Structure:

      → app
      → manifests
      	→ AndroidManifest.xml
      → java
	→ mobiledev.unb.ca.lab1HelloWorld
		→ MainActivity.java
	→ mobiledev.unb.ca.lab1HelloWorld (androidTest)
		→ ApplicationTest.java
      → res
	→ drawable
		→ (empty)
 	→ layout
		→ activity_main.xml
	→ menu
		→ menu_main.xml
	→ mipmap
		→ ic_launcher.png (hdpi)
		→ ic_launcher.png (mdpi)
		→ ic_launcher.png (xhdpi)
		→ ic_launcher.png (xxhdpi)
	→ values
		→ dimens.xml (2)
			→ dimens.xml
			→ dimens.xml (w820dp)
		→ strings.xml
		→ styles.xml

###### 7a. manifests directory

This directory contains the AndroidManifest.xml file. This file contains information that pertains to how your application should run, what activities within your project it depends on, and of those which is to run when the application is first launched, as well as any device/account access permissions users must agree to before being able to download your application if placed on the Google Play Store.

Additional AndroidManifest.xml information: [https://developer.android.com/guide/topics/manifest/manifest-intro.html](https://developer.android.com/guide/topics/manifest/manifest-intro.html)

**2. Deliverable** The application theme is also described in this AndroidManifest file; provide the attribute tag that describes this.

Note the android:label attribute tag contains the application name we gave to our project. If you click this an @string resource named app_name will be revealed in as being the source of this text. We’ll explore the strings.xml resource below.

###### 7b. java directory

This java folder contains two sub directories, one of which is for application testing. We've yet to develop anything that requires thorough testing, so we'll focus on the non-test folder for ```mobiledev.unb.ca.lab1introduction```.

Given that no additional content has been added to the project in terms of Java classes so far, the only java resource file is our MainActivity.java that is generated when we created the project. Opening this file will reveal some familiar Java syntax and perhaps some unfamiliar Java syntax as well.

A class named MainActivity is declared and the file contains some imports and the package under which this file belongs is denoted. The ```@Override``` annotation indicates that the subsequent method is being overwritten against the super methods from the extended Activity class.

Here we see ```onCreate()```, ```onCreateOptionsMenu()```, and ```onOptionsItemSelected()``` are all overridden. They take as parameters a ```Bundle```, ```Menu```, and ```MenuItem``` object respectively. In ```onCreate()``` the ```Bundle``` is passed up to the superclass from which we are overriding. Read the comments auto-generated for ```onCreateOptionsMenu()``` and ```onOptionsItemSelected()``` to discover their purpose.

Explore http://developer.android.com/reference/android/app/Activity.html and find the method ```setContentView()``` that is used inside the ```onCreate()``` method. Be sure to find the method which takes the proper parameter type, in this case a layout resource ID.

**3. Deliverable** Describe what the ```setContentView()``` method call accomplishes for your application


###### 7c. res directory

This directory contains many different types of resources that get used inside an application. The drawable folder, empty for now, can contain custom image files that can be utilized in your application to add finely customized theming or object styles, icons or any other visual assets necessary for your application.  

The layout directory contains activity_main.xml and content_main.xml. The actvivity_main.xml is the resource that is sent as a parameter to the ```setContentView()``` method call in our MainActivity.java class file discussed above. Open this file to once again reveal the GUI layout editor. Near the bottom left corner of this layout editor window, switch from the Design tab to the Text tab.  You’ll be presented with a hierarchy of XML tags each containing attributes relevant to defining the layout for the application you created in the GUI editor. Layouts can be designed in either fashion, by GUI or XML. The menu directory contains a similar file for customizing the layout for menu appearances in your application.

The mipmap directory contains icons used for launch deck icons for the application. In a future lab we will customize these. Note how multiple files are supplied; this is to target devices with differing levels of pixel density screens.

Explore http://developer.android.com/guide/topics/ui/declaring-layout.html.

**4. Deliverable** What are the three common layout types? Why is it important to define IDs for view objects, especially when using RelativeLayout?

Under the values directory there first is a colors.xml. Initially this file contains the ```Primary```, ```Primary Dark```, and ```Accent``` colors for your application. These are used to simply create a cohesive color scheme experience across the application by allowing the Android OS to allow existing Android View Object components to rely on these three initial colors for coloring common application components (```TaskBars```, etc.).

Second is a dimens.xml directory that contains XML containing Android Design guideline levels of margin and padding for application viewing.

Most interesting in the values directory are the strings.xml and styles.xml. Open strings.xml and you’ll see XML tags containing the application name and the default Settings menu text display. This allows a string to be referenced in multiple locations within an application and only require being altered in one location to propagate changes throughout the app. New strings can be defined here and then referenced using the ```@string/string_name``` syntax we saw earlier. You can change your application string name here and it will be reflected along your application ```Toolbar``` when the activity is run.

The styles.xml is where application theming and specific Android object styling can be achieved. We will cover styles and theming in a future lab.

Under Gradle Scripts:

###### 7d. build.gradle (Module: app)

This gradle file is used to establish build requirements to ensure the proper syntax are being met for your target SDK choice. Notice there is a mindSdkVersion, targetSdkVersion, and versionCode value. The minSdkVersion indicates what the lowest SDK that is supported by your application (Google often names SDK versions by dessert options; Froyo, Gingerbread, Ice Cream Sandwich, Lollipop, Marshmallow). The targetSdkVersion is the optimized version you have in mind for your device; the general approach is to design with the newest in mind and support as large a percentage of the device population as possible. If the versionCode value is changed from one application development to the next, users will have updates triggered on their device.

###### 8. Supporting Different Languages

Now that we’re familiar with the strings.xml resource file, let’s take a look at how to add locale-specific string support.  On the Project Structure tab along the left-hand side of Android Studio, at the top where it currently says Android, set the view to Project.

![](http://i.imgur.com/BfxJ6ZO.png)

Right click the app/src/main/res directory and select New → Android resource directory. Set the directory name to values-es. Repeat the same process and set the directory name to values-fr.

Now right-click each of these folders and create a New → Values resource file and call each strings.xml.
In the values-es/strings.xml file, add the following:

```xml

<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">Mi Aplicación</string>
    <string name="action_settings">Ajustes</string>
</resources>
```
In the values-fr/strings.xml file, add the following:

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">Mon Application</string>
    <string name="action_settings">Paramètres</string>
</resources>
```

Run the application via the emulator once again. Access the settings menu from inside the emulator and set the language to French. Then locate your application icon in the application deck. Open your application and you will see your French strings have been selected based on your custom locale choice. Set the locale to es-Spanish and do the same.

Notice that the string "Hello World!" is unaffected! This is because this string is hard-coded in content_main.xml. This is bad practice. Add a new string for "Hello World!" (or its translation) to each of your string resource files. Then modify content_main.xml to use this new string.

Once you've done this, take screenshots of your application with French and Spanish translations and save them. Then set the language of the emulator back to your preferred language.


###### 9. Console Log Debugging

Being able to identify what is occurring within your application at certain points in the running cycle is important for any development process. Android Studio offers the ability to have log messages printed to the console. Open MainActivity.java. Under the MainActivity class declare the following string:

```java
private static final String TAG = "MainActivity";
```

Now, inside ```onCreate()```, add the following:

```java
Log.i(TAG, "This is a log display!");
```

Run the application via the emulator or device once more. Along the bottom portion of Android Studio, note the Run, TODO, 6: Android, Terminal, 0: Messages tabs. Click the 6: Android tab. Near the top of this window locate the Log level: dropdown. Set to Info and in the adjacent search field type MainActivity. You’ll be presented with a console log information that you built into the ```onCreate()``` function. This tactic can be utilized throughout the development cycle to test certain portions of your code to know how an application is behaving and where in the Activity lifecycle your application may be encountering problems.!

**5. Deliverable** Take and save a screenshot of the log message window.
