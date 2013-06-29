# A play web app

## Howto

`play idea`

Import or open it in idea

### Create a "Play 2 App" run configuration in idea

Check "Enable auto-reload", it will auto compile your view changes etc.

Run it in debug mode

### Compile views automatically, without idea run configuration

`play` followed by `~compile`

## Build for cloudfoundry

`play clean compile`
`play -Dconfig.file=conf/cloud.conf dist`

## Deploy to cloudfoundry

`cf push`

## Troubleshooting

### New dependencies aren't descovered

`play idea`

### Idea won't run my "Play 2 App"

Settings -> Play Configuration -> Home: /usr/local/Cellar/play/2.1.1/libexec/

### Idea won't compile

Mark `target/scala-2.10/classes_managed` and `target/scala-2.10/src_managed/main` as Source Folders

### Sbt looks for e.g. jedis_2.10 which does not exist in central

Don't use double %% like this: `"redis.clients" %% "jedis" % "2.1.0"`

Do this: `"redis.clients" % "jedis" % "2.1.0"`
