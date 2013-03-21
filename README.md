# Use the BB 10 UI in your android project.

This project try to get the BB 10 UI ( or part of the UI in this stage ) to your Android project.

## Important:
- Right now RoboGuice projects aren't supported.
- BB 10 Font is commercial. Use it at your own risk.
- Not supported components will fallback to Android Holo.

## How to use it

1) Download the repo from GitHub and import it into your Eclipse workspace.

2) Go to your project properties.

3) In the Android section go to the bottom and add the bb10ui project in the Project Libraries section.

4) Replace setContentView with (new BBeizer(this)).magic( R.layout.main );

Some important things:
- BBeizer reference could be saved to activate or de-activate the title feature.

Example
``` java
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        
    (new BBeizer(this)).magic( R.layout.main );
}
```

5) Enjoy!

6) Extend your application style in styles.xml from @style/Theme.BB10Light to get components UI. Remember to set the style in your application manifest.
* This is optional step.

Example
``` xml
<!-- Application theme. -->
<style name="AppTheme" parent="@style/Theme.BB10Light">
</style>
```

- Make your app looks like Blackberry app just on Blackberry devices:

``` java
int layout = R.layout.main;
if( android.os.Build.MANUFACTURER.equalsIgnoreCase("RIM") || android.os.Build.MANUFACTURER.equalsIgnoreCase("BLACKBERRY") ) {
	(new BBeizer(this)).setContentView(layout);
} else {
	setContentView(layout);
}
```

## License

    Copyright 2013 Román A. Sarria

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.