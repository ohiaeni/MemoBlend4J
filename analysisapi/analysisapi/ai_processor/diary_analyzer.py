import os
from openai import OpenAI
from fastapi import HTTPException

class DiaryAnalyzer:
  """
  日記データをAIで解析するクラス(作成中)。
  """

  def __init__(self):
    self.client = OpenAI()
    self.client.api_key = os.getenv("OPENAI_API_KEY")

  def analyze(self, json_data: dict):
    if "content" in json_data:
      response = self.client.chat.completions.create(
        model="gpt-3.5-turbo-0125",
        messages=[
          {"role": "system", "content": "あなたは、優秀なアシスタントです"},
          {"role": "user", "content": "次の文章に対する感想を教えて。" + json_data["content"]},],
        max_tokens=100
      )
      return response
    
    else:
      raise HTTPException(status_code=400, detail="日記データに 'content' キーが含まれていません")
