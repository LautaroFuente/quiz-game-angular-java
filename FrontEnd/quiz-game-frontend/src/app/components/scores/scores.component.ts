import { Component, OnDestroy, OnInit } from '@angular/core';
import { ScoresServiceService } from '../../services/scores-service.service';
import { Score } from '../../interfaces/Score.interface';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-scores',
  standalone: true,
  imports: [],
  templateUrl: './scores.component.html',
  styleUrl: './scores.component.css',
})
export class ScoresComponent implements OnInit, OnDestroy{
  scores!: Score[];

  private unsubscribe$ = new Subject<void>();

  constructor(private scoreService: ScoresServiceService) {}

  ngOnInit(): void {
    this.scoreService.getScores().pipe(takeUntil(this.unsubscribe$)).subscribe(
      (response) => {
        console.log('Informacion obtenida', response);
        this.scores = response.data;
      },
      (error) => console.log(`Error`, error)
    );
  }

  ngOnDestroy(): void {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }
}
