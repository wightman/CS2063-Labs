# Lab 8 Notifications and Broadcast Receivers

## Pre-lab readings

Notifications:
http://developer.android.com/guide/topics/ui/notifiers/notifications.html
Read at least up to the end of "Creating a simple notification"

PendingIntents:
http://developer.android.com/reference/android/app/PendingIntent.html
(Class Overview)

Alarms: http://developer.android.com/training/scheduling/alarms.html
(Up to end of Cancel an Alarm)

Monitoring battery state:
http://developer.android.com/training/monitoring-device-state/battery-monitoring.html
(Overview and Monitor Significant Chances in Battery Level)

BroadcastReceivers:
http://developer.android.com/reference/android/content/BroadcastReceiver.html
(Class Overview)

## Introduction

In this lab we will build a photo taking app that reminds the user to
take a photo at regular intervals. This could be, for example, the
start of an app for a [365 Project](http://365project.org/)-like
photography project. We will also make the app adapt to the battery
state of the device to conserve power when the battery is low. In
	building this app we will learn about Android notifications, alarms
and BroadcastReceivers.




## Todo

Download the Lab 8 Skeleton from
[CS2063labs](https://github.com/wightman/CS2063-Labs/). This is a
single-```Activity``` app that has a button that dispatches an
implicit ```Intent``` to take a photo, and then saves the photo. (It's
the same code that we used to take a photo in Lab 3.)

Read the skeleton code and make sure you understand what it's doing.

### Notifications

First we'll add the functionality to have an alarm go off at regular
intervals to remind the user to take a picture. We'll start by writing
code to respond to this alarm; then we'll go back and set the
alarm. To receive an alarm we use a ```BroadcastReceiver```. Let's
create one.

Create a new Java file called
```AlarmReceiver.java```. ```AlarmReceiver``` will extend
```BroadcastReceiver``` .

Override ```AlarmReceiver```'s ```onReceive``` method. This method
will be called when the ```BroadcastReceiver``` receives a
broadcast. Just put a ```Log``` message in here for now.

We've added a component to our application. App components need to be
registered in ```AndroidManifest.xml```. To register our new
```BroadcastReceiver```, add the following ```receiver``` element
inside of the ```application``` element in ```AndroidManifest.xml``` :


```
        <receiver android:name=".AlarmReceiver"/>
```


In ```MainActivity.onCreate``` set an alarm. The alarm should repeat
roughly every 60 seconds, and should wake the device. The action of
the alarm should be to start ```AlarmReceiver```. The documentation on
[alarms](http://developer.android.com/training/scheduling/alarms.html)
from the pre-lab reading will help you here.

(We would typically use alarms for much longer durations. For example,
for our daily photo app we might set the alarm to run once per
day. However, this short interval will be useful for testing and
debugging. It would be quite frustrating to have to wait a day to
determine if the alarm code you wrote is working properly...)

At this point you can run your app, and you should see log messages
from ```BroadcastReceiver``` indicating that ```onReceive``` is being
called.

Now let's go back to ```AlarmReceiver``` and finish implementing
```onReceive```. Follow this
[guide](http://developer.android.com/guide/topics/ui/notifiers/notifications.html#SimpleNotification)
(which you read as part of the pre-lab) to create a notification. The
action of this notification will be to start
```MainActivity```. (I.e., clicking on the notification takes the user
back to the app.) When building your notification, you can set the
small icon to ```R.mipmap.ic_launcher```, and you should set
[```setAutoCancel```](http://developer.android.com/reference/android/app/Notification.Builder.html#setAutoCancel%28boolean%29)
to ```true``` so that when the user clicks on the notification it is
dismissed.

Now you can run your app. When the alarm fires, you should see the
notifications that you have created. Notice that the alarm continues
to fire even after you have closed the app.

### Conserving power

Now we will modify our app to conserve power when the battery is low
by disabling the alarm. Android sends an ```ACTION_BATTERY_LOW```
intent when the system changes to a low battery state, and an
```ACTION_BATTERY_OKAY``` intent when the battery level is high enough
again after previously being low. We will receive these intents to
change the behavior of our app.

In ```MainActivity``` create a new ```BroadcastReceiver``` called
```batteryInfoReceiver``` and ```@Override``` its ```onReceive```
method. This will look like this:

```
private BroadcastReceiver batteryInfoReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
    }
};
```

In ```MainActivity.onCreate``` create a new ```IntentFilter``` that
includes the actions ```ACTION_BATTERY_LOW``` and
```ACTION_BATTERY_OKAY```. Register ```batteryInfoReceiver``` so that
it will receive any intent that matches the filter you just created.

Hint: Create an
[```IntentFilter```](http://developer.android.com/reference/android/content/IntentFilter.html)
and call
[```addAction```](http://developer.android.com/reference/android/content/IntentFilter.html#addAction(java.lang.String)
to add the appropriate actions to it.

Hint: [```registerReceiver```](http://developer.android.com/reference/android/content/Context.html#registerReceiver%28android.content.BroadcastReceiver,%20android.content.IntentFilter%29)


Now implement ```batteryInfoReceiver.onReceive()```. If an
```ACTION_BATTERY_LOW``` intent is received, cancel the alarm. If an
```ACTION_BATTERY_OKAY``` intent is received, set the alarm just like
you did previously. Also show a ```Toast``` indicating which intent
was received.

We dynamically registered ```batteryInfoReceiver``` and so we also
need to unregister it to avoid memory leaks. ```@Override```
```MainActivity.onDestroy()``` and unregister
```batteryInfoReceiver``` here.


### Emulator

The Android emulator allows us to simulate a device in various states,
such as on a mobile or wifi network, or connected to a power source or
not. It also allows us to simulate events like receiving a text
message.

Here we will learn a bit more about the emulator so that we can use it
to test the features we implemented above for conserving power. (It
would be quite frustrating to test this on a physical device. We would
have to wait for our device's battery to discharge in order to test
it!)

Documentation on the emulator is here:
http://developer.android.com/tools/devices/emulator.html In this lab
we will explore just a few features of the emulator. There is much,
much more.

#### Connecting to the emulator

Open the "Terminal" tab at the bottom of AndroidStudio. Connect to the
emulator with the following command:

```
$ telnet localhost XXXX
```

where ```XXXX``` is the port that the emulator is running on. You can
find this in the window bar for the window the emulator is running
in. For example, the port for the emulator below is 5554.

![Emulator](http://i.imgur.com/W9eMkcN.png)


To set the device to be disconnected from an AC power supply, do the
following:

```
$ power ac off
```

To set the battery level use the following, where ```N``` is the
battery level (e.g., 5, 100):

```
$ power capacity N
```

You can use this to test the behavior of your app in different battery
states. (Setting the capacity to 15 or lower should trigger
```BATTERY_ACTION_LOW```; setting it back to 50 should
trigger ```BATTERY_ACTION_OKAY```.)

Also try sending an SMS to the emulator:

```
$ sms send 555-5555 "Hello"
```

## Deliverables

Show your working app running on an emulator to the instructor or TA
