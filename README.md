# Storm-Twitter-Hello-World
A working java project example to show you how to pull twitter streams by storm
You need to prepare:
- Your twitter credential
- Java and Maven environment

## Get Your Twitter Credential

Go to https://apps.twitter.com/ to create a new App,
after that you will get consumer info in the "Keys and Access Tokens" tab
1. Consumer Key (API Key)
2. Consumer Secret (API Secret) &nbsp;
&nbsp;&nbsp;
then click generate access token button under the page,
you will get
&nbsp;
3. Access Token
4. Access Token Secret

and that's all we need for this twitter hello-world project.

## Maven Build the jar with dependencies
```console
$ mvn clean compile assembly:single
```

## Running the executable jar
Remember to replace the credential info with what you get in the above step.
```console
$ java -cp target/storm-twitter-hello-world-jar-with-dependencies.jar -Dtwitter4j.debug=true -Dtwitter4j.oauth.consumerKey=xxxxxxxxxxxxxxxxxxxxxxxxx -Dtwitter4j.oauth.consumerSecret=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -Dtwitter4j.oauth.accessToken=xxxxxxxxxx-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -Dtwitter4j.oauth.accessTokenSecret=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx storm.helloworld.Topology
```

##### The screen output will be like:
&nbsp;
```console
YouTube censorship RAMPAGE running amok as all the GOOD people keep getting terminated https   t co lBFqo4Uscy
Hahahaha😅😅😅😂😂 https   t co ckfzTkBoPA
RT  BANDAIFN  🎩『 快盗戦隊ルパンレンジャーVS警察戦隊パトレンジャー』🚨予約開始‼️パトレン3号 明神つかさが愛するぬいぐるみ達💕がマスコットチャームになって登場✨「ふわぱん！」「サメーラ ピンクセーラーVer  」「じゃがとん」の3種類❗️本日13時より予…
```

##### Have fun!
