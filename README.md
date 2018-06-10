[![](https://jitpack.io/v/JanStoltman/CommonIntents.svg)](https://jitpack.io/#JanStoltman/CommonIntents)

# CommonIntents
## Descrition
Common Intents is an Android library which provides the most common android intents in ready-to-take one-liney fashion. It's main goal it to save your time and prevent you from writing the same intent creation code again and again for the most common tasks. All intents are taken from and implemented according to [Android documentation](https://developer.android.com/guide/components/intents-common). 

**MinSdk - 14**
**TargetSdk - 28**


## Usage

### Importing
    #Project level file
    allprojects {
      repositories {
          (...)
          maven { url 'https://jitpack.io' }
      }
    }
    
    #Module level gradle file
    dependencies {
        implementation 'com.github.JanStoltman:CommonIntents:v0.8'
    }
    
### Intent creation
To create an intent use *create* method

    SetAlarmIntent.create("", 0, 0)
    
### Resolve activity 
To resolve if any activity can handle the intent use *resolveActivity*

    SetAlarmIntent.resolveActivity(getPackageManager())
    
### Check permissons 
To check if you application has the required permissons to use certain intent use *checkPermissons*

    SetAlarmIntent.checkPermissions(getApplicationContext())
    
### Check permissons
To request the required permissons that are used by certain intent use *resolveActivity*

    SetAlarmIntent.askForPermissions(this as Activity, REQUEST_CODE)

## Contribution
If you would like to contrubiute, feel free to create a pull request with your changes. Try to describe what you did in each commit. For other common intents create new packages and for intents that are app-specific (Twitter, Evernote...) please create new utility class in a sub-package named after that application.

## Tests
Whole library is going to be tested using [Espresso-Intents](https://developer.android.com/training/testing/espresso/intents]

## Tasks
Todo list for this library in the nearest future
- []
