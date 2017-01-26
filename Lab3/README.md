# Lab 3

####Background: 

For this lab you need to be familiar with with how to build an
```Intent``` and how to construct and call new Activities:

* http://developer.android.com/training/basics/firstapp/starting-activity.html#BuildIntent
* http://developer.android.com/training/basics/firstapp/starting-activity.html#CreateActivity
  
Here is a list of common Intents. This isn't necessary for pre-lab reading, but you may find it valuable during this course and any future Android development.

http://developer.android.com/guide/components/intents-common.html


####Objectives:

You are given an Android project containing one ```Activity```. You task is developing a thorough understanding of starting new activities by ```Intent```s, briefly introduced last lab with more exploration below. The Android API Guide succinctly states an "```Intent``` is a messaging object you can use to request an action from another app component" and for that reason they are a very powerful tool for getting feature rich applications running very quickly. We will cover:

* explicit and implicit Intents
* passing information with Intents
* application-specific Intent Filters
* permissions
* startActivityForResult()

The goal of this lab is to create a multiple ```Activity``` application that uses multiple explicit and implicit Intents. We'll access activities from within our application as well as request access for activities outside our application. We'll access camera functionality as well as the capability to send email using existing applications on the device. We'll also explore a potential pitfall if the behavior of the ```Task``` backstack is misunderstood.

If emulating for this lab you'll need to turn on emulated device camera access. Run an application, access the Launch emulator option, and click the ellipsis next to your emulated device. Under ```Advanced Settings```, set both front and back camera to emulated. Now we can access camera applications and snap photos using this emulated device.

You will also need to set up an email account on the emulated device to send email from it. To set up an email account, access ```Settings → Accounts → Add Account``` on the emulated device. 

####Intent Types

New Activities are started by passing the ```startActivity()``` method an ```Intent``` parameter. Intents can be of **Explicit** (stated) or **Implicit** (implied) nature. Intents can be sent from an ```Activity``` component to start new Activities, which we’ve covered in some detail during Lab 2. Intents can also  start ```Services``` and ```Broadcast Receivers```, which we’ll cover in later labs, as well as be started _by_ ```Services``` and ```Broadcast Receivers```.

_Explicit Intent_ - typically used to start a component (eg. ```Activity```/```Service```/```Broadcast Receiver```) that exists within your application project; something coded by you or imported for a specified purpose with your application. It is called explicit because you know the name of the component you intend to use, so you can explicitly announce it to the ```startActivity()``` method, and it will be handled as such.

_Implicit Intent_ - if you are calling for a component from another application installed on the device, you may not have knowledge of the component name that you are requesting; you just wish to make use of the component if it’s available on the device. An application can choose to specify if it contains components that satisfy certain request types by supplying ```Intent Filters``` in their ```AndroidManifest.xml``` file. By providing such filters, their application can make certain activities available to satisfy some request from other applications. This creates even more modularity in creating application services. If multiple applications on the device satisfy some request (eg. to take a photo), a list of possible choices is presented to the user; users can then choose, or not, to have their choice set as Default behavior for this file or service request type for that application.
	
Investigate the constructors available for building ```Intent``` objects. Take a look at some of the public methods available to Intents. With the option to attach Extra information to an ```Intent```, Intents provide a great way to send data between two Activities. By packing an ```Intent``` with Extras, its contents can be checked for, and then unpacked, in the receiving ```Activity```. This is similar behavior to how we attached counter values using ```savedInstanceState``` in ```onSaveInstanceState()``` from ```ActivityOne``` in ```Lab 2```. Instead of using ```savedInstanceState.put<<some_value_type>>()```, we instead do ```intentName.putExtra(type, value)```.

http://developer.android.com/reference/android/content/Intent.html#lfields

####Procedure:
Import the Lab 3 Skeleton code as a new project in Android Studio.

######Reminder Remember to make habit of adding a ```LogCat``` documentation ```String``` to all Activities and a ```Log.i``` method to each ```Activity``` method for testing purposes! Take a look at the following documentation and/or ```Lab 2``` Skeleton code for ```ActivityOne```.

http://developer.android.com/reference/android/util/Log.html

**1.** Once imported, note the “Start” ```Button``` in the center of the ```Main Activity``` layout. Highlight this ```Button``` and give it an ID in the Properties panel.

Programmatically capture a reference to this Start ```Button``` layout component from ```MainActivity``` and give it a [setOnClickListener()](http://developer.android.com/reference/android/widget/Button.html) in the ```Activity```’s ```onCreate()``` method. Take a look at the linked documentation or back to ```ActivityOne``` in ```Lab 2``` if you forget this procedure.

**2.** What's the second ```Activity``` class in the project? Take note of the Java resource file name.

**3.** Construct an [Intent](http://developer.android.com/guide/components/intents-filters.html#ExampleExplicit) inside the ```setOnClickListener()``` and use it to start the second ```Activity```.
	
View the layout associated with this second ```Activity```. There are three buttons: one representing ```Camera``` access, one representing Email access, and one representing a Back ```Button```. Give each ```Button``` an ```id``` in the Properties panel (or do this by editing the XML file).

**4.** Now capture references to these buttons. For each, define an empty ```setOnClickListener()```. 
* The Camera ```Button``` is going to send out an implicit ```Intent``` requesting a ```Camera``` application ```Activity``` that can handle taking photos.
* The Email ```Button``` is going to send out an implicit ```Intent``` requesting an Email ```Activity``` with which to send email.
* The Return ```Button``` will execute an explicit ```Intent``` requesting ```Main Activity```; interesting ```Task``` backstack implications will be explored from using this approach.

In ```Lab 2``` we executed an Explicit ```Intent``` to start ```ActivityTwo``` from the ```Context``` of ```ActivityOne```. Now we will define our application’s ```Intent``` to have some function performed on its behalf using implicit intents.

When Implicitly defining an ```Intent```, we pass along an ```Action Constant```. This tells the device how to locate applications that contain an ```Activity``` that is capable of responding to your application’s request. If a default application ```Activity``` has been set to satisfy that function on the device, it will generally be the ```Activity``` started.

Let’s demonstrate this by announcing our application’s ```Intent``` to send an email. We don’t need to concern ourselves with the underlying method an email application implements to succeed at transferring our message to the recipient. We need only to announce our intention to send email to the Android operating system and it will inform the user what options are available.

What we can do, if we choose, is provide some preliminary information to the ```Activity``` we intend to start. This preliminary information is sent along with the ```Intent``` as attached Extras when we call ```startActivity()``` or ```startActivityForResult()``` with the ```Intent``` we created as parameter. This ```Extra``` information is then usable within the component (eg. ```Activity```/```Service```/```Broadcast Receiver```) we started.


Here are a list of possible Actions and Extras available for communicating with email applications on the device, as well as email ```Intent``` creation examples:
http://developer.android.com/guide/components/intents-common.html#Email

**5. Deliverable** Develop your email ```Button```’s ```setOnClickListener()```. Build an email-only ```Intent``` that does not include attachments. For testing, give your ```Intent``` three extras:  one for the recipient email addresses (just have one recipient, and make it you), one for the the subject line “CS2063 Lab 3”, and one for the body of the email “This is a test email!”. The final email ```Button``` action should be to ```startActivity()``` with your new ```Intent``` as parameter. 

Certain requested components may require access to device hardware, such as the camera. If your application requests use of a component that in turn will make use of such hardware, you must announce that in your application’s manifest file. 

**6.** Edit [AndroidManifest.xml](http://developer.android.com/guide/topics/manifest/manifest-intro.html) to include ```<uses-permission>``` and ```<uses-feature>``` tags for the Camera and enabling writing to device storage. You can read more about explicit ```Intent``` filtering with hardware example here:
http://developer.android.com/guide/topics/manifest/uses-feature-element.html#declared


**7.** Hardware feature use now declared, you can wire your camera ```Button```’s ```setOnClickListener()``` event to implicitly alert the operating system of your ```Activity```'s ```Intent``` to access to the camera functionality. Doing so will provide the user a list of applications to satisfy the request to take a photo. 

Use the example here to take a picture and save the full-size photo:
* http://developer.android.com/training/camera/photobasics.html#TaskPath

There is one small problem with the sample code. In ```createImageFile()``` change this line:

     mCurrentPhotoPath = "file:" + image.getAbsolutePath(); // Don't do this

to this:
 
     mCurrentPhotoPath = image.getAbsolutePath(); // Do this instead


**8.** We've saved the photo, and we know where we saved it (in ```mCurrentPhotoPath```), but we need to alert Android to add this file to the photos database so that other applications, like a gallery application, know about it. Add ```galleryAddPic()``` from the following link to your code:

http://developer.android.com/training/camera/photobasics.html#TaskGallery

But where should we call ```galleryAddPic()```? We launched our intent to take a photo using ```startActivityForResult()```. When the activity that is started completes, Android will call our ```Acivity```'s ```onActivityResult``` method. Learn about this method here:

http://developer.android.com/training/basics/intents/result.html#ReceiveResult

Implement ```onActivityResult``` in your ```Activity``` and have it call ```galleryAddPic()``` if it receives the correct request code and result code.


**9.** Now we have to make our back ```Button``` work. To do so, we are going to build an ```Intent``` to explicitly call our ```MainActivity```. This is done similarly to how we built and started an ```Intent``` to get from our ```MainActivity``` to ```ExternalActivityCalls```.

**10. Deliverable** Run your application. Take a photo using the camera button. Then send an email to yourself, using the mail button, with the photo you just took as an attachment. Open this email and take a photo of it.

**11. Deliverable** Restart your application. From the ```MainActivity```, click the Start ```Button```. Then click Back, then Start again. Do this a few times. Now, begin using the device soft-key back button to traverse the ```Task``` backstack.

Write a short description of your observations and relate this to what you learned about the backstack in the previous lab. How could you modify the implementation of your ```Activity```'s back button to behave similarly to the device's soft-key back button?



**Deliverables** Show the following to the instructor or TA

* Your working app
* The screenshot you took of the email sent by your app
* Your answers to the questions about the back button

