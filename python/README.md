# Python API

## 環境構築手順
1. pipenv のインストール
 ```
  pip install pipenv
 ```

2. Pipfileを元に仮想環境を再現
 ```
  pipenv install
 ```

3. 仮想環境のアクティブ化
 ```
  pipenv shell
 ```


## 起動方法
1. pythonフォルダに移動
 ```
  cd python
 ```

2. 下記コマンドでサーバー起動
 ```
 uvicorn main:app --reload
 ```
