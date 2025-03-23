from fastapi import FastAPI, HTTPException
import httpx
import uvicorn
from analysisapi.ai_processor.diary_analyzer import DiaryAnalyzer
from analysisapi.loader.config_loader import ConfigLoader

# インスタンスの生成
app = FastAPI()
diary_analyzer = DiaryAnalyzer()
config_loader = ConfigLoader()

@app.get("/diary/{id}")
async def get_diary(id: int):
  """
  Spring BootのAPIから指定idの日記を取得し、AI解析を行う。
  """

  # xmlから取得した日記apiへのurlを設定
  DIARY_API_URL = config_loader.load_diary_api_url()

  # urlを組み立てる
  url = f"{DIARY_API_URL}/{id}"

  # 非同期処理でSpring Bootのapiを呼び出し
  async with httpx.AsyncClient() as client:
    response = await client.get(url)
  
  # ステータスコードが200以外の場合はエラーを返す
  if response.status_code != 200:
    raise HTTPException(status_code=response.status_code, detail="Spring Boot APIエラー")

  response_json = response.json()

  # DiaryAnalyzer クラスでAI解析を行う
  response = diary_analyzer.analyze(response_json)

  print("合計使用トークン数：", response.usage.total_tokens)

  return response.choices[0].message.content

def main():
  # uvicornでFastAPIアプリを起動
  uvicorn.run(app, host="127.0.0.1", port=8000)
