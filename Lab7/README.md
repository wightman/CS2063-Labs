# Lab 7


In lecture we've seen how to detect gestures, create animations, and
play sounds. In this lab we'll put these pieces together to create a
game-like app.

The "game" begins with a blank screen. Tapping on the screen will
create a bubble at that location. The bubble will have a random size,
rotation, and direction of movement. Tapping on a bubble will pop it
and play a popping sound. Starting a fling gesture on a bubble will
fling that bubble off the screen, at a velocity determined by the
fling gesture. If left alone, a bubble will eventually move off the
screen. A counter at the bottom of the screen keeps track of the
number of bubbles on the screen.

If you'd like to see the app in action, a sample solution has been
installed on the Nexus 7's that the instructor has in the lab. Try it
out!

## Todo

Examine the code to get an understanding of what's already
implemented. You don't need to understand every line, but should
understand the overall structure of the app.

This lab requires you to learn independently and read lots of
documentation. The help section below gives you some pointers. Ask
questions if you get stuck!

Complete the TODOs in ```BubbleActivity```.

Have fun!

## Help

SoundPool http://developer.android.com/reference/android/media/SoundPool.html Also see the ```SoundPool``` example on the course github.

MotionEvent
http://developer.android.com/reference/android/view/MotionEvent.html 

See the ```GestureDetector``` examples here:
http://developer.android.com/training/gestures/detector.html and on
the course github for how to delegate ```MotionEvent```s.

See https://docs.oracle.com/javase/6/docs/api/java/util/Random.html
for information on generating random numbers in Java.

```Bitmap``` documentation (including how to create a scaled
```Bitmap```) http://developer.android.com/reference/android/graphics/Bitmap.html

More information on ```Canvas```:
http://developer.android.com/reference/android/graphics/Canvas.html


## Deliverable

Show your working app to the instructor or TA.

## Credits

This lab is based on materials from [Adam
Porter](https://github.com/aporter).
