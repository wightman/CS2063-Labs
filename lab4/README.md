# Lab 4

### Pre-lab readings

* [Styles and Themes](http://developer.android.com/guide/topics/ui/themes.html)

* [Fragments](http://developer.android.com/guide/components/fragments.html) up to the end of _Design Philosophy_



## Part 1: Fragments

You've now been introduced to enough layout, ```Activity Lifecycle```, and ```Intent``` behavior that you can start to appreciate some device-specific design concerns. Android is offered on devices of varying capabilities in terms of computing power, storage, screen size, and more. When designing applications for Android, you must be aware that your application may run on devices much different than the one which you designed and tested it for. With this in mind, there have to be design decisions about how your application behaves when presented with these varying circumstances, which is why you should take advantage of the Android Virtual Devices (AVD) available in Android Studio. 

Take tablets vs. phones, for instance. Tablets generally have much more screen real estate than a phone. Even a phone in landscape mode (turned horizontal) has much more horizontal screen space than it does when in portrait mode (vertical).

It is possible for your applications to respond to available screen space with different layouts specific to the screen space available at any one point in time on the device. A ```Fragment``` is a great way to customize layouts based on available screen real estate.

Your task for the remainder of the lab is to investigate the ```Fragment``` class and develop an application that consists of one ```Activity``` that will contain two Buttons within a ```LinearLayout```. Each ```Button```, named ```FragmentA``` and ```FragmentB``` respectively, will swap which ```Fragment``` is displayed.

When the device is running in vertical/portrait mode, only one ```Fragment``` at a time will be displayed. (The two buttons will also be displayed). If the device is in horizontal/landscape mode, then both Fragments will be displayed at once, side by side. (No buttons will be displayed in this case.) Examples are provided below.

![](http://i.imgur.com/I7EI6JR.png)
![](http://i.imgur.com/l6jNFEs.png)

[The Official Android Training Guide](http://developer.android.com/training/basics/fragments/creating.html#Create) describes a ```Fragment``` as _"a modular section of an activity, which has its own lifecycle, receives its own input events, and which you can add or remove while the activity is running (sort of like a "sub activity" that you can reuse in different activities)."_

Fragments are simply a class of Android objects that allow modular user interfaces to exist fluidly within an ```Activity Lifecycle```. They can be set statically in the layout file (which works great for the described landscape implementation here) or they can be programmatically adjusted within the ```Activity``` code at runtime (as works best for the portrait/default implementation described here). There are also multiple ```Fragment``` subclasses we can extend from that are intended for specific uses, such as containing lists of information or images. In this lab, we’ll simply be extending the base ```Fragment``` class.

Here’s are some resources to reference regarding Fragments:

http://developer.android.com/guide/components/fragments.html

http://developer.android.com/training/basics/fragments/creating.html#Create

http://developer.android.com/training/basics/fragments/fragment-ui.html

http://developer.android.com/training/basics/fragments/communicating.html

http://developer.android.com/reference/android/app/Fragment.html#Lifecycle

Start a new project and create an empty ```Activity```. Create two new Java classes, one for each fragment; call them ```FragmentA.java``` and ```FragmentB.java```.

To get an idea how the ```Fragment Lifecycle``` works with the ```Activity``` to which is is attached, refer to the fragment lifecyle link above. This will provide an idea of what methods you must ```@Override``` to meet your objectives. As shown in the _Create a Fragment_ link, we execute layout related business in ```onCreateView()```. For this app you will only need to implement ```onCreateView()```. In ```onCreateView()``` use a layout name of ```activity_fragment_a``` and ```_b```.

Your project will have errors. Now create the necessary layout file for each fragment. Each layout will consist of a single ```TextView``` contained within a ```LinearLayout```.

Now create an orientation specific layout for ```activity_main.xml```. To do so, access the ```Project``` structure (refer to Lab 1 for a screenshot if you forget how to navigate to this structure view). Under your ```res/``` directory, create a new resource directory titled ```layout-land```, short for landscape. The layout file you specify here (named the same as your default layout file, ```activity_main.xml```) will activate whenever the device or emulator is put into landscape orientation.

Start by editing your main (non-landscape) layout. Make it a ```LinearLayout``` with vertical orientation, containing two buttons. Give the ```LinearLayout``` an ```@+id```; this will enable you to programmatically swap two Fragments.

_Hint_: If you’re experiencing rendering errors in the layout files, navigate to ```styles.xml``` and change ```<style name="AppTheme" parent=”Theme.AppCompat.Light.DarkActionBar">``` to ```<style name="AppTheme" parent="Base.Theme.AppCompat.Light.DarkActionBar">```.

Now edit your landscape layout. Make it a ```LinearLayout``` with horizontal orientation, containing your two fragments. See the fragment documentation for help:

http://developer.android.com/training/basics/fragments/creating.html#AddInLayout

_Hint_: To position two objects side-by-side in a ```LinearLayout``` described via XML, give each object ```android:layout_width="0dp"``` and ```android:layout_weight="1"```.

At this point you can try running your app. However, we haven't added any functionality to the buttons. See this documentation on fragments for help on implementing the action of your buttons:

http://developer.android.com/guide/components/fragments.html#Transactions

Now is a good time to address the ability to support older device models. Some Android API levels did not come equipped with objects such as Fragments. As such, the Android Open Source Project would include support libraries to assist with backward compatibility. This is an important consideration to keep in mind if you create applications for Google Play and intend to support as many devices as possible. For this lab, we’ll be focusing on modern devices and targeting API 23 so we’ll choose to import the standard ```Fragment``` class and not the support library variation.


## Part 2: User Interface Elements and Styling##

There are many pre-built components at a UI designer’s disposal. Looking in Android Studio at a layout XML file in Design mode reveals a list of Layouts, Widgets, Text Fields, Media Containers, Data & Time presentation, and more, all with highly customizable attribute sets that enable creating sleek applications.

In Part I we’ll work to style only one of these elements, but you’ll quickly see how you can use the element’s Properties panel to create an appearance closer to what you envision for your own application by applying the same techniques to other user interface elements.

Start a fresh project in Android Studio with a Blank ```Activity```. On the ```Layout``` ```Design``` tab, remove the Hello World! ```TextView``` and locate the ```Button``` widget and drop one into the editor. On the ```Button``` widget’s ```Properties```, edit ```background``` and select a color of your choice from the palette. Find the button’s ```layout:alignParent``` and ```layout:centerInParent``` properties and note how you can alter the location of the ```Button``` on the screen by setting the these checkbox attributes. Explore some of the other properties. Not all properties are necessarily applicable to each element, but exploring the properties available will give you an idea of what is possible for most elements.

Once you’ve built a ```Button``` you’re happy with the appearance of, navigate to the ```Layout``` ```Text``` tab. You’ll see your selected alterations to this ```Button``` element presented in XML. If you decided you wanted to make small changes to the subset of properties you’ve already set attributes for, you could choose to do so from the text editor as well as the GUI editor.

These textual representations become valuable when creating ```Styles``` and ```Themes``` that will extend across your application to all components declaring the style. Rather than specifying all properties each time you create a new ```Button``` or user-interface object, you can define a style to fit a certain subset of properties and set the appearance for elements with one simple ```style="STYLE_NAME"``` line.

Defining the default appearance of element types by creating ```Styles``` via XML allow applications to be themed and branded. Each time you implement an element in your application it will come equipped with your defined default style whenever it is set with the specific style name you've created. This allows for simplifying the creation of a cohesive, branded user experience and helps your applications stand out.

Take at a look at the documentation on [Defining Styles](http://developer.android.com/guide/topics/ui/themes.html#DefiningStyles) for insight into how to apply this technique to your project!

Define a style based on the design you just gave your ```Button```. Navigate back to the ```Layout``` ```Text``` Editor and copy all previous XML generated by the editor to represent the ```Button``` you created in the GUI editor. Paste your ```Button``` XML for reference in any text editor. Navigate to ```res/values/styles.xml```. Here we will use the developed ```Button``` style to define a style we can apply to any future ```Button```. Underneath the ```</style>``` tag we will define a new style as follows:

```<style name="Lab3Example" parent="@style/Base.Theme.AppCompat">```

  ```<item name="android:.....">attribute_value</item>```

As you can see, these stylistic elements implement inheritance behaviors.

Each ```android:.....``` portion of the item fields will be supplied the particular properties element your ```Button``` implements. The ```attribute_value``` portion will be whatever that element is set to. For example, if your ```Button``` has

```android:layout_width="wrap_content"```, your style code would appear as

```<item name="android:layout_width">wrap_content</item>```

Do this for all stylistic changes you made to your ```Button``` to create a style you can subsequently set for any ```Button``` you create going forward. Once your style is built, return to the ```activity_main.xml``` layout file.

Replace the XML code for your ```Button``` here entirely with ```<Button style=”@style/Lab3Example”/>```. Your ```Button``` will once again take on the look you defined in the GUI editor, and will do so whenever you chose to provide a ```Button``` element that style in the future.

Here is a sample used to produce the following ```Button```:

![](http://i.imgur.com/n8NTcbF.png)
![](http://i.imgur.com/aBGobbn.png)

Text is still set on the button's layout XML file via ```android:text="@strings/STRING_NAME"```.


**Deliverables** Show your working apps from parts 1 and 2 to the
  instructor or TA
