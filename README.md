# Products App

This project is an Android application designed to display a list of products. It adheres to Clean Architecture principles and leverages Retrofit for network operations, Hilt for dependency injection, and includes unit tests. The user interface is constructed using Fragments and XML layouts.

## Table of Contents

- [Architecture](#architecture)
- [Libraries Used](#libraries-used)
- [Setup](#setup)
- [Usage](#usage)
- [Features](#features)
- [Unit Testing](#unit-testing)
- [Design Images](#design-images)
- [Video](#video)
- [Contributing](#contributing)
- [Contacts](#contacts)

## Architecture

The project follows Clean Architecture, which divides the code into distinct layers, including the Repository Pattern and MVVM:

1. **Domain Layer**: Contains business logic and use cases.
2. **Data Layer**: Manages data operations, including network requests and data caching.
3. **Presentation Layer**: Comprises ViewModels, Fragments, and UI components.

## Libraries Used

- [Retrofit](https://square.github.io/retrofit/): For network requests.
- [Hilt](https://dagger.dev/hilt/): For dependency injection.
- [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow): For observable data.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel): For managing UI-related data.
- [Coroutines](https://developer.android.com/kotlin/coroutines): For asynchronous programming.
- [JUnit](https://junit.org/junit5/): For unit testing.
- [Mockito](https://site.mockito.org/): For mocking in tests.
- [Glide](https://github.com/bumptech/glide): For loading images.

## Setup

To run this project, follow these steps:

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/products-app.git
    cd products-app
    ```

2. Open the project in Android Studio:
    ```sh
    open -a "Android Studio"
    ```

3. Sync the project with Gradle files by clicking the "Sync Now" button in the banner at the top of the IDE.

4. Build and run the app on an emulator or physical device by clicking the "Run" button.

## Usage

To use the app:

1. Launch the app on your device or emulator.
2. The app will show a splash screen followed by a list of products.
3. Tap on a product to view its details.

## Features

- **Display Products List**: Fetches and shows a list of products from a remote API.
- **Error Handling**: Displays appropriate messages for network errors.
- **Loading Indicators**: Shows a Shimmer Effect while fetching data.

## Unit Testing

The project includes unit tests for ViewModel and use cases.

To run the tests:
1. Open the test directory in Android Studio.
2. Right-click on the `com.example.route_task` package and select "Run Tests".

## Design Images

### Splash Screen
![splash_screen](https://github.com/user-attachments/assets/f3edc702-084b-4aec-8353-47025dcbbb88)

### Shimmer Effect
![shimmer_effect](https://github.com/user-attachments/assets/41bf5026-c7e7-4059-bf07-b2b481b2927f)

### Products List
![product_list](https://github.com/user-attachments/assets/9e6516d7-7152-4954-a749-c5d55aa14b41)

## Video
[Watch the video](https://github.com/user-attachments/assets/92fe906e-c82b-45ef-9acf-601b6b615a44)

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch with a descriptive name.
3. Make your changes.
4. Submit a pull request.

## Contacts

- Email: [drabdullh2002.1@gmail.com](mailto:drabdullh2002.1@gmail.com)
