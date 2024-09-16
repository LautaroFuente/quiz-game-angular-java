import { Difficulty } from '../types/difficulty.type';

export interface Score {
  userName: string;
  userEmail: string;
  userScore: number;
  win: boolean;
  difficulty: Difficulty;
}
