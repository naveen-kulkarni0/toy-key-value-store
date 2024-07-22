# Toy Key Value Store using mysql
This demonstrates a sample persistent key value store using mysql as backend. This store exposes
1. Add 
2. Add with expiry
3. Remove
4. Update
5. Update with expiry
As this is a toy key value store the data type supported for value is just a string. But it can be
enhanced as required.


# Getting started
1. Start the mysql using docker-compose `$docker-compose up -d --wait`
2. We can perform any operations once mysql is up.
3. The init.sql also comes with `delete_old_data` which is basically a mysql event for cleanup.
    The event has a limit of 5k deletes basically to minimise the B+ tree re-balancing during deletes.