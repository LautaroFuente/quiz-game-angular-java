import { Difficulty } from "../types/difficulty.type";

export interface Question {
    id:number;
    description: string;
    difficulty: Difficulty;
  }