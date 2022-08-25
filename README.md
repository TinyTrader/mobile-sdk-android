# mobile-sdk-android
Perpetual futures SDK for Android

## Installation Via Maven
#### 1.Add the following lines to `project -> build.gradle`:
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
        maven {
            url 'https://maven.aliyun.com/repository/public'
        }
        maven {
            credentials {
                username 'maven user name'
                password 'maven password'
            }
            url 'https://packages.aliyun.com/maven/repository/2269018-release-hMOQ2q/'
        }
       
    }
}
```

#### 2.Add the following lines to `project -> app -> build.gradle` :
```gradle
    implementation 'com.sass.contract-lib:sass-contract:0.0.2'
```

## Quick Tutorial
#### 1. Setup the SDK on App startup
```kotlin
    SassLibSDK.init(
    application, /* your application */
    `5fu3`, /*channel id value*/
    host, /* host name*/
    sfg6, /*your token*/
    BuildConfig.DEBUG, /*is debug mode, print the log if true*/
    object : SassLibSDK.SassLibSdkCallBack {
        override fun goLogin(context: Context) {
            // jump to login
        }

        override fun transfer() {
            // jump to transfer
        }
    })
```
you need to call these functions after the user login or logout
```kotlin
SassLibSDK.login(sfg6) /* call after login，@param sfg6 is your token*/
SassLibSDK.logout() /*call after logout*/
```
#### 2. you should nested the PermanentContractFragment into your Activity like this:
```kotlin
class SassMainActivity : Activity() {
    override fun getContentViewId(): Int {
        return R.layout.activity_fragment_container
    }

    override fun injectDagger() {
    }

    override fun initViewsAndEvents() {
        back_iv?.setOnClickListener { finish() }
        supportFragmentManager.beginTransaction()
            .add(R.id.fg_container, PermanentContractFragment.newInstance())
            .commitAllowingStateLoss()
    }
}
```
or you can use the SassMainActivity directly like this:
```kotlin
    startActivity(Intent(context, SassMainActivity::class.java))
```
#### 3. change the theme color, override the `sass_lib_main` in your `colror.xml`，like this:
```xml
    <color name="sass_lib_main">#D0A858</color>
```

SassLibSDK.class function list：
```kotlin
init /*init the SDK*/
resetHost /*change the host*/
login /*login*/
logout /*logout*/
connectSocket /*connect the web socket*/
disconnectSocket /*disconnect the web socket*/
```

Tips:
### before launch the SDK's PermanentContractFragment, you need to call `connectSocket`, 
### after finish the PermanentContractFragment, you need to call `disconnectSocket`.
### if you just use SassMainActivity, you don't need to call [`connectSocket`,`connectSocket`]



