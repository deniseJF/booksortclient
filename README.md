## Running

To run the client, you first have to install the [sorting-service](https://github.com/deniseJF/sorting-service) using:

    $ cd <PATH_TO_SORTING_SERVICE>
    $ mvn clean install

After that, you can run the sample client with:

    $ cd <PATH_TO_BOOKSORTCLIENT>
    $ ./run_client.sh


Optionally, you can pass a path to an alternate config file, containing another configuration for sorting Book instances.

    $ ./run_client.sh /PATH/TO/ALTERNATE/CONFIG.json

### Recommended platform

The projects were developed targetting Java 7, using Oracle JDK 7.
