# Email Automation
The Email automation system automates the process that company can use to communicate with multiple clients/ customers. 
The information that need to be changed in every email can be stored in the csv. The csv header can then be used as placeholders in the email template for automation process.

## Sample Text file (Template)
To:[[email]]
Subject: Insurance company – information about recent data breach
Dear [[first_name]] [[last_name]],
As you may have heard or read, last month we learned that criminals forced their way into our systems, and stole information about our customers.

## Smaple csv
"first_name" , "last_name" , "company_name" , "email"
"Art"      , "venere"      , "Benton", "art@venere.org"
"Josephine"  , "R, Darakjy", "Chanay", "josie55@hotmail.com"

## Sample Output
To:art@venere.org
Subject:Insurance company – information about recent data breach
Dear Art Venere,
As you may have heard or read, last month we learned that criminals forced their way into our systems, and stole information about our customers.

## Running the code
Run Index.java. In commandline paste the following after replacing the placeholders with the right paths:
--email --email-template <email-tamplate.txt> --output-dir <output directory path> --csv-file <csv_file.csv>

Note: the order of the command does not matter.