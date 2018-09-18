# -*- coding: utf-8 -*-
"""
Created on Wed Jul 25 13:26:01 2018

@author: Ankit Varshney
"""
import re
import pandas as pa

path = r'D:\Documents\Study\Dalhousie\Summer2018\Data\Project\Dataset\Dice_US_jobs.csv';
df = pa.read_csv(path, encoding = "ISO-8859-1",  error_bad_lines=False)

for index, row in df.iterrows():
    print(row['sector'])
    row['sector'] = re.sub(',', ' ', str(row['sector']))
    row['sector'] = re.sub(":", ' ', row['sector'])
    row['sector'] = re.sub("!", ' ', row['sector'])
    
df = df["sector"]
df = df.to_csv('us_jobs.csv',header=['job_requirement'],index=False)
    