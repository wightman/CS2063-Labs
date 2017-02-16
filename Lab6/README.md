# Lab 6 - AsyncTask

In lecture we've seen the importance of moving long-running operations
off of the UI thread and into a worker thread. In this lab you will
implement (portions of) this functionality using an ```AsyncTask```.

Start by downloading the Lab 6 skeleton code.

This app uses the master/detail flow pattern from last week. However,
instead of loading data from a file on the device, this week we'll use
data downloaded from the web. Specifically we'll download data about
recent earthquakes from the United States Geological Survey. 

This
[website](http://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php)
describes a variety [JSON](http://www.json.org/) feeds that provide
information about recent earthquakes. We will use data from the feed
that provides information about [all earthquakes in the past
day](http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.geojson).

The skeleton code is largely similar to Lab 5, except it displays
different data. The ```RecyclerView``` displays a list of the
magnitudes and locations of recent earthquakes. The detail view
displays this information for a specific earthquake, and also includes
the longitude and latitude of the earthquake.

```DataModel``` handles downloading the data and parsing the JSON into
an ```ArrayList``` of ```GeoData```
objects. ```GeoDataDetailActivity``` and ```GeoDataDetailFragment```
are largely similar to the corresponding classes from last week, but
handle data about earthquakes instead of
courses. ```GeoDataListActivity``` is also quite similar to what we
saw last week, but it includes an ```AsyncTask``` to download the data
in a worker thread.

## Todo

Complete the TODOs in ```GeoDataListActivity``` and ```DataModel```.

Make sure your app behaves as expected with and without a network
connection. Make sure the floating action button (pink button in the
bottom right corner) still works while the data is refreshing.


## Deliverable

Show your working app to the instructor or TA.

## Final words

This lab was developed and tested primarily on a Nexus 5. Use other
devices at your peril.
