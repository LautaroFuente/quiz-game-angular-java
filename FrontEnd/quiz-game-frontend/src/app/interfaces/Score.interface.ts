import { Difficulty } from '../types/difficulty.type';
import { User } from './User.interface';

export interface Score {
  id:number
  user:User;
  score: number;
  win: boolean;
  difficulty: Difficulty;
}
