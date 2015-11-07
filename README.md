## GitCoin - Simplistic Crypto-Currency Simulator

### Usage

Thoughts/Todos

* Adding basic block chain -- each coin mined would build on top
of previous block
* Including block metadata as hash ingredients -- parent, author,
new nonce
* Server setting "target" hash value -- for new block to be generated,
it must produce a message hash lower than the supplied target
* Server target dynamic adjusting -- is it possible to figure out a
loose target-setting algo so that difficulty can be increased or decreased
for more miners

Block ingredients:

* Author name
* Author pub key?
* Parent block id (hash)
* New block message
* Ownership token -- Server generates UID and encrypts using author's public key;
author can use this token to redeem or transfer the coin

### Running

To start a web server for the application, run:

    lein run

### DB Migrations

Migrations are managed using the [Migratus](https://github.com/yogthos/migratus)
library.

Migration files are stored in `resources/db/migrations`.

You can create a new migration file using:

```
lein migratus create create-examples-table
```

Once your migrations are prepared, you can run them with:

```
lein migratus migrate
```

or revert the last one with:

```
lein migratus rollback
```

### DB Setup

The db will need to be created in the appropriate postgres
server.

__Locally__

```
createdb git-coin_development
```

__Heroku__

```
heroku addons:create heroku-postgresql:hobby-dev
```

### License

Copyright © 2015 Horace Williams

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
