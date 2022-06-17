### spark-shell
   - Retrieve keytab from Storage account.
        hdfs dfs -get abfss://app@sathyaprivatestorage.dfs.core.windows.net/sathya/sathya.keytab
   - Open a spark-shell.
        spark-shell --principal ${USER}@AZURE.ONMICROSOFT.COM --keytab ${USER}.keytab --num-executors 5 --conf "spark.driver.memory=8G" --executor-memory 3G
   - Create a scala query to the file like flat-20220616.scala
   - Load the file
        :load /home/AZURE/user/sathya/flat-20220616.scala
   - Results can be seen in console, for any show commands
