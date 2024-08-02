# DateFormatterKR

DateFormatterKR is a Java library that simplifies date formatting tasks for Korean users. 
It provides a set of utility methods for handling dates in various formats, 
including relative time format, duration time format, and more.

## Features

- Format a date with a given pattern.
- Parse a date string with a given pattern.
- Get a list of dates between the start and end date.
- Get a relative time format between the start and target date.
- Get a duration time format between the start and end date.
- Get a day of week with a given date and text style.
- Check if the given date string is valid with the given pattern.

## Installation

### Gradle

Add the following dependency to your `build.gradle` file:

```groovy
dependencies {
    implementation 'com.github.etff:DateFormatterKR:1.0.0'
}
```

## Maven
Add the following dependency to your pom.xml file:

``` xml
<dependency>
  <groupId>com.github.etff</groupId>
  <artifactId>DateFormatterKR</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Usage
Here is a basic example of using DateFormatterKR
```java
LocalDate startDate = LocalDate.of(2021, 1, 1);
LocalDate endDate = LocalDate.of(2021, 1, 3);

// Get dates in range
List<LocalDate> dates = DateFormatterKR.getDatesInRange(startDate, endDate);

// Get relative time format
String relativeTime = DateFormatterKR.toRelativeTimeFormat(startDate, endDate);

// Get duration time format
String durationTime = DateFormatterKR.toDurationTimeFormat(startDate, endDate);

```

## License
License
This project is licensed under the terms of the MIT license. 
For more information, see the LICENSE file.
