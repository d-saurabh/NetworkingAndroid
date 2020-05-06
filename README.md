# Networking in Android APP

In this project you can learn how to connect to the outside world using Google's `Volley Library`.
Advantages:
- We don't have to worry about AsyncTask anymore
- Well tested and proven
- Faster and efficient parsing and image loading.

### StringRequest
Step 1: Add Volley Library
- Files -> Project Structure -> App -> Dependencies -> app -> + > Library Dependencies -> com.dubsmash.volley [SEARCH]

Step 2: Create some request
- Use a `StringRequest` class to create a request
- Pass the `Request.Method.GET`, url , response listener and error listener
- Always add the request to the `RequestQueue` so that volley can handle it.

Step 3: Allow accessing the internet permission
- In AndroidMainifest.xml add `<uses-permission android:name="android.permission.INTERNET"/>`

Note: remember to initialize the request queue `vollyeRequest = Volley.newRequestQueue(this)`

### JsonArrayRequest

- Its same as that of the String Request just that you need to create a JsonArrayRequest instead.
- If your api call expecting to return array of json use this


### JsonObjectRequest

- Its same as that of the other Request just that you need to create a JsonObjectRequest instead.
- If your api call expecting to return a specific JSON object
