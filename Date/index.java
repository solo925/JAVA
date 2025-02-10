# **📅 Complete Guide to Handling Dates in Java**

Java provides multiple ways to work with dates, times, and formatting. The most commonly used APIs are:

1. **java.util.Date** (Legacy, replaced by `LocalDateTime`)
2. **java.util.Calendar** (Legacy, replaced by `LocalDateTime`)
3. **java.time (Java 8+)** 🏆 **(Recommended)**
4. **java.text.SimpleDateFormat** (For formatting)

---

# **1️⃣ Using `java.util.Date` (LEGACY)**
✅ Represents a specific moment in time.  
❌ **Deprecated** due to inconsistencies and lack of time zone support.

### **Example: Get Current Date**
```java
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("Current Date: " + date);
    }
}
```
### **Output**
```
Current Date: Sat Feb 08 14:30:45 UTC 2025
```

### **Convert `Date` to `long` (Milliseconds since Epoch)**
```java
long timestamp = date.getTime();
System.out.println("Timestamp: " + timestamp);
```

### **Creating a Specific Date**
```java
Date specificDate = new Date(1234567890000L); // Timestamp
System.out.println("Specific Date: " + specificDate);
```
---

# **2️⃣ Using `java.util.Calendar` (LEGACY)**
✅ Supports manipulating dates (adding days, months, etc.).  
❌ **Verbose and complicated**, replaced by `java.time`.

### **Example: Get Year, Month, and Day**
```java
import java.util.Calendar;

public class CalendarExample {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Months start from 0
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("Year: " + year + ", Month: " + month + ", Day: " + day);
    }
}
```

### **Adding Days to a Date**
```java
calendar.add(Calendar.DAY_OF_MONTH, 5);
System.out.println("Date after 5 days: " + calendar.getTime());
```

---

# **3️⃣ Using `java.time` (Java 8+) 🏆 (RECOMMENDED)**
✅ **More powerful & modern API**  
✅ **Immutable & thread-safe**  
✅ **Supports time zones, durations, periods, and more**

## **📌 Important Classes in `java.time`**
| Class | Description |
|-------|------------|
| `LocalDate` | Represents only a date (yyyy-MM-dd) |
| `LocalTime` | Represents only a time (HH:mm:ss) |
| `LocalDateTime` | Represents date & time (yyyy-MM-dd HH:mm:ss) |
| `ZonedDateTime` | Represents date, time & time zone |
| `Instant` | Represents a timestamp (epoch time) |
| `Duration` | Represents time difference (hours, minutes, seconds) |
| `Period` | Represents date difference (days, months, years) |
| `DateTimeFormatter` | Used for formatting dates |

---

## **4️⃣ Using `LocalDate`, `LocalTime`, `LocalDateTime`**
### **Getting Current Date, Time & DateTime**
```java
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("Current Date: " + date);
        System.out.println("Current Time: " + time);
        System.out.println("Current DateTime: " + dateTime);
    }
}
```
### **Output**
```
Current Date: 2025-02-08
Current Time: 14:35:12.123
Current DateTime: 2025-02-08T14:35:12.123
```

---

## **5️⃣ Formatting Dates (`DateTimeFormatter`)**
`DateTimeFormatter` allows custom formatting.

### **Example: Custom Date Format**
```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDateExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDate = now.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);
    }
}
```
### **Output**
```
Formatted Date: 2025-02-08 14:40:00
```

---

## **6️⃣ Parsing a Date String**
Convert a `String` into a `LocalDateTime` object.

```java
String dateString = "2025-02-08 14:30";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
LocalDateTime parsedDate = LocalDateTime.parse(dateString, formatter);

System.out.println("Parsed Date: " + parsedDate);
```

---

## **7️⃣ Adding & Subtracting Dates**
Use `plus()` and `minus()` methods.

```java
LocalDate today = LocalDate.now();
LocalDate nextWeek = today.plusDays(7);
LocalDate lastMonth = today.minusMonths(1);

System.out.println("Today: " + today);
System.out.println("Next Week: " + nextWeek);
System.out.println("Last Month: " + lastMonth);
```

---

## **8️⃣ Working with Time Zones (`ZonedDateTime`)**
Use `ZonedDateTime` to handle different time zones.

### **Get Current Time in a Specific Time Zone**
```java
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class TimeZoneExample {
    public static void main(String[] args) {
        ZonedDateTime nowInTokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Current Time in Tokyo: " + nowInTokyo);
    }
}
```

### **List All Available Time Zones**
```java
import java.time.ZoneId;

public class TimeZonesExample {
    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds());
    }
}
```

---

## **9️⃣ Comparing Dates**
You can compare two dates using `isBefore()` and `isAfter()`.

```java
LocalDate date1 = LocalDate.of(2025, 2, 8);
LocalDate date2 = LocalDate.of(2025, 3, 1);

if (date1.isBefore(date2)) {
    System.out.println(date1 + " is before " + date2);
} else {
    System.out.println(date1 + " is after " + date2);
}
```

---

## **🔟 Measuring Time Differences (`Duration` & `Period`)**
Use `Duration` for time differences (hours, minutes, seconds).  
Use `Period` for date differences (days, months, years).

```java
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class DurationExample {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2025, 2, 8, 10, 0);
        LocalDateTime end = LocalDateTime.of(2025, 2, 8, 15, 30);

        Duration duration = Duration.between(start, end);
        System.out.println("Duration: " + duration.toHours() + " hours");

        Period period = Period.between(start.toLocalDate(), end.toLocalDate());
        System.out.println("Period: " + period.getDays() + " days");
    }
}
```

### **Output**
```
Duration: 5 hours
Period: 0 days
```

---

# **✅ Summary**
| Feature | Legacy (`Date`, `Calendar`) | Java 8+ (`java.time`) |
|---------|----------------|-----------------|
| **Current Date & Time** | `new Date()` | `LocalDateTime.now()` |
| **Manipulating Dates** | `calendar.add()` | `date.plusDays(1)` |
| **Formatting** | `SimpleDateFormat` | `DateTimeFormatter` |
| **Time Zones** | Harder to handle | `ZonedDateTime` |

✅ **Use `java.time` (Java 8+) for modern date handling.**  
✅ **Use `DateTimeFormatter` for formatting & parsing.**  

Would you like specific examples on **date conversions**? 😊