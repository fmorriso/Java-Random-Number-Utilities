# Java Random Number Utilities

A set of random number utilities that defaults to including both the minimum and maximum values 
in the range of eligible return values plus allows some user control of the tolerance value used in
generating random double precision values. 
There are API calls that allow the user to __explicitly__ specify true/false if the max value should be
eligible to be returned.
That tolerance value, if made small enough, can help generate random double precision values closer to
requested minimum and maximum values.

## Tools Used

| Tool     |    Version |
|:---------|-----------:|
| Java     |   24.0.1.0 |
| VSCode   |    1.100.0 |
| IntelliJ | 2025.1.1.1 |

## Change History

| Date       | Description                                                             |
|:-----------|:------------------------------------------------------------------------|
| 2024       | Initial creation                                                        |
| 2024-08-21 | add additional comments to RandomNumberUtilities                        |
| 2024-08-24 | Verify code runs with IntelliJ 2024.2.0.1                               |
| 2025-04-05 | Move repo from GitLab to GitHub                                         |
| 2025-05-08 | separate output to make start/end of each test easier to spot.          |
| 2025-05-11 | verify code works with IntelliJ 2025.1.1.1 and VSCode 1.100.1           |
| 2025-05-13 | add getRandomIntInRange(int min, int max, boolean inclusive)            |
| 2025-05-14 | finish API calls that permit explicit inclusion/exclusion of max value. |
