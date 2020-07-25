# YoFio Technical Test
This is the YoFio technical Test for Android Developer.

## Business Workflow

The business workflow to implement is a membership payments from a mobile device with a custom payment platform given by YoFio into their backend. The objective of this demo application is:

- Make the login process into the app.
- Make the register process to the platform and login later.
- View all of the payments made by the current user.
- Make a payment to the user's membership.

## Architecture Pattern

The architecture pattern chosen for this demo is MVVM (Model-View-ViewModel), which is an standarized architecture pattern for mobile development, no matter the SDK we're using. The usage of MVVM goes as follows:

![MVVM General Diagram](https://miro.medium.com/max/875/1*5kNXJ7aFSGJvuh4r4egpTg.png)

- The View are handled by the fragments on the app.
- Each fragment has its own ViewModel
- The model part is handled into another Kotlin Module using Clean Architecture (*core*)

### About Clean Architecture

Clean Architecture is the name popularized by Robert C. Martin aka. _Uncle Bob_ for the way of working with code as contiguous layers which are interconnected only with the layers that are beside them as shown in the following diagram:

![Clean Architecture Diagram](https://xurxodev.com/content/images/2016/07/CleanArchitecture-8b00a9d7e2543fa9ca76b81b05066629.jpg)

So, for making an API connection from our ViewModel, we must ensure our ViewModel is capable of communicate with our Use Cases (in the app I've call them **Interactors**) and the Interactors communicate with the necessary repositories for making the REST API call.

## Tools used during development

For the development of this test, I've used the following:

- Programming Language: Kotlin
- Dependency Injection: Koin
- ReactiveX: RxJava and RxAndroid
- External Libraries: Retrofit for REST API connection

## Deployment

- Just add water. In the dist folder you'll find a debug and release APK for testing.
- For development, we should use Android Studio 4.0 (previous versions are not supported).
- In case you want to use IntelliJ Idea, keep in mind you must install the Android plugin for this IDE and Android SDK **manually**. Refer to this site for further instructions https://www.mathworks.com/help/supportpkg/android/ug/install-android-sdk-platform-packages-and-sdk-tools.html

## Completed Workflows

- Login
- Register
- Show Payments in Dashboard
- Make a Payment.

## Opportunity Areas

- Unit Testing.
- Better UX/UI for the app.
- General Documentation according to JavaDOC standards.