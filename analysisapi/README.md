# analysisapi の使用方法

## 環境構築手順
1. analysisapiフォルダに移動
   ```
   cd analysisapi
   ```

2. pipenv のインストール
   ```
   pip install pipenv
   ```

3. Pipfileを元に仮想環境を再現
    ```
    pipenv install
    ```

4. 仮想環境のアクティブ化
   ```
   pipenv shell
   ```


## サーバー起動手順
1. analysisapiフォルダに移動
   ```
   cd analysisapi
   ```

2. main.pyを実行
    ```
    python main.py
    ```
    または、下記コマンドでサーバー起動
    ```
    uvicorn main:app --reload
    ```