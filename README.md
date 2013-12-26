Tutorial-Item
=============

開発環境
* Minecraft 1.6.4
* Minecraft Forge #964
* IntelliJ IDEA 12.6

Eclipse+Forge#953以下向け:

src/main/java/comフォルダ以下をsrc/minecraft/にコピー.

src/main/resources/assetsフォルダをbin/minecraft/にコピー.

Eclipse上で実行する場合, assetsフォルダはeclipse/minecraft/bin/assets/にコピー.


IDEA+ForgeGradle向け:

root/srcに上書きするか, githubからclone→モジュール化しない→setting.gradleのincludeにディレクトリ名を追加

チュートリアル内容
==================

com.sample.item.basic

* Item追加の基本

com.sample.item.icon

* アイテムのアイコンの基本
* バニラのテクスチャを利用するアイコン
* 独自のテクスチャを利用するアイコン
* RGB乗算による色違いのアイコン
* 2つのアイコンを重ねたアイコン

com.sample.item.food

* 食べ物追加の基本
* ポーション効果を持つ食べ物の追加

com.sample.item.tool

* 単純なツール追加の基本
* ショベル, 斧, つるはし, クワの追加

com.sample.item.weapon

* 単純な武器の追加

com.sample.item.armor

* 単純な防具4種の追加

com.sample.item.bow

* 単純な弓の追加
