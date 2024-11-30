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

