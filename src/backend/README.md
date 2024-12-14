# バックエンドの説明

## pullする際に最初に行うこと
1. SECRET_KEYの再生成

    プロジェクトをプルした時など、SECRET_KEYを再生成する必要がある。
    プロジェクト直下で以下のコマンドを実行。

    `$ python manage.py shell`

    対話モードで以下のコードを実行すると、SECRET_KEYが出力される。

    ```
    >>> from django.core.management.utils import get_random_secret_key
    >>> get_random_secret_key()
    'xxx-xxxx'
    ```

    下記のように"settings_local.py"を作成し、中身に先ほど出力されたSECRET_KEYを設定する(settings_local_sample.pyをベースに書き換えてもよい)。

    MemoBlend/src/backend/config/settings_local.py

    中身
    ```
    # Djangoの秘密キー
    SECRET_KEY = 'xxx-xxxx'
    ```

    参考：
    https://chigusa-web.com/blog/django-secret/

2. Pipfile.lockから環境の再現

    下記コマンドでPipfile.lockからパッケージをインストール。
    ```
    $ pipenv sync
    $ pipenv sync --dev    # --devオプションで通常のパッケージの他に開発用パッケージもインストールされる
    ```

    補足：
    - PipfileとPipfile.lockの違い
        
        Pipfileにはパッケージのバージョンは指定していない場合が多い。一方、Pipfile.lockはパッケージのバージョンが指定されている。そのため、詳細なバージョンに合わせて環境を作成する場合は、Pipfile.lockを用いる必要がある。
        
        なお、Pipfileを用いる場合は下記のコマンドを実行する。
        ```
        $ pipenv install
        $ pipenv install --dev    # --devオプションで通常のパッケージの他に開発用パッケージもインストールされる
        ```
    
    - pipenvでのパッケージのインストール方法

        下記コマンドでパッケージをインストールを行う。

        ```
        pipenv install "パッケージ名"
        pipenv install --dev "パッケージ名" # 開発用パッケージの場合
        ```

        なお、このときPipfile、Pipfile.lockには自動でパッケージが追記される。
    
    参考：https://qiita.com/y-tsutsu/items/54c10e0b2c6b565c887a
